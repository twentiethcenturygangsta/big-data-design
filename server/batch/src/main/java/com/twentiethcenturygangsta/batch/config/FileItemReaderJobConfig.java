package com.twentiethcenturygangsta.batch.config;

import com.twentiethcenturygangsta.database.domain.ProductCSV;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;

@Slf4j
@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class FileItemReaderJobConfig {
    private static final int chunkSize = 1000;
    private final DataSource dataSource;
    private final ProductItemProcessor processor;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean
    public FlatFileItemReader<ProductCSV> reader() {
        FlatFileItemReader flatFileItemReader = new FlatFileItemReaderBuilder<ProductCSV>()
                .name("ProductItemReader")
                .resource(new ClassPathResource("/productsTest.csv"))
                .delimited()
                .names(new String[]{
                        "id", "ProductCode", "ProductName", "ProductPrice", "ProductImage", "ProductImage100",
                        "ProductImage110", "ProductImage120", "ProductImage130", "ProductImage140", "ProductImage150",
                        "ProductImage170", "ProductImage200", "ProductImage250", "ProductImage270", "ProductImage300",
                        "Text1", "Text2", "SellerNick", "Seller", "SellerGrd", "Rating", "DetailPageUrl",
                        "SalePrice", "Delivery", "ReviewCount", "BuySatisfy", "MinorYn", "Benefit"
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<ProductCSV>() {
                    { setTargetType(ProductCSV.class);}
                })
                .build();
        flatFileItemReader.setLinesToSkip(1);
        return flatFileItemReader;
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<ProductCSV> stepWriter1() {
        return new JdbcBatchItemWriterBuilder<ProductCSV>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(
                        "INSERT INTO seller (nick_name, user_name, grd) " +
                                "VALUES(:SellerNick, :Seller, :SellerGrd ) " +
                                "ON DUPLICATE KEY UPDATE nick_name= :SellerNick"
                )
                .dataSource(dataSource)
                .build();
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<ProductCSV> stepWriter2() {
        return new JdbcBatchItemWriterBuilder<ProductCSV>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(
                        "INSERT IGNORE INTO product (code, name, price, sale_price, rating, detail_page_url, delivery, review_count, buy_satisfy, is_minor) " +
                                "VALUES(:ProductCode, :ProductName, :ProductPrice, :SalePrice, :Rating, :DetailPageUrl, :Delivery, :ReviewCount, :buySatisfy, :MinorYn)" +
                                "ON DUPLICATE KEY UPDATE code= :ProductCode"
                )
                .dataSource(dataSource)
                .build();
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<ProductCSV> stepWriter3() {
        return new JdbcBatchItemWriterBuilder<ProductCSV>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(
                        "INSERT INTO product_image (base, size100, size110, size120, size130, size140, size150, size170, size200, size250, size270, size300) " +
                                "VALUES(:ProductImage, :ProductImage100, :ProductImage110, :ProductImage120, :ProductImage130, :ProductImage140, :ProductImage150, :ProductImage170, :ProductImage200, :ProductImage250, :ProductImage270, :ProductImage300) "
                )
                .dataSource(dataSource)
                .build();
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<ProductCSV> stepConnect1() {
        return new JdbcBatchItemWriterBuilder<ProductCSV>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(
                        "UPDATE product_image SET product_id = (SELECT id FROM product WHERE code = :ProductCode) WHERE base = :ProductImage"
                )
                .dataSource(dataSource)
                .build();
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<ProductCSV> stepConnect2() {
        return new JdbcBatchItemWriterBuilder<ProductCSV>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(
                        "UPDATE product SET seller_id = (SELECT id FROM seller WHERE nick_name = :SellerNick) WHERE code = :ProductCode"
                )
                .dataSource(dataSource)
                .build();
    }

    @Bean
    @StepScope
    public CompositeItemWriter<ProductCSV> compositeItemWriter(
            @Qualifier("stepWriter1") JdbcBatchItemWriter<ProductCSV> jdbcUpdateTable1Writer,
            @Qualifier("stepWriter2") JdbcBatchItemWriter<ProductCSV> jdbcInsertTable2Writer,
            @Qualifier("stepWriter3") JdbcBatchItemWriter<ProductCSV> jdbcInsertTable3Writer) {
        CompositeItemWriter<ProductCSV> writer = new CompositeItemWriter<>();
        writer.setDelegates(Arrays.asList(jdbcUpdateTable1Writer, jdbcInsertTable2Writer, jdbcInsertTable3Writer));
        return writer;
    }

    @Bean
    @StepScope
    public CompositeItemWriter<ProductCSV> compositeItemConnector(
            @Qualifier("stepConnect1") JdbcBatchItemWriter<ProductCSV> jdbcUpdateTable1Writer,
            @Qualifier("stepConnect2") JdbcBatchItemWriter<ProductCSV> jdbcInsertTable2Writer) {
        CompositeItemWriter<ProductCSV> writer = new CompositeItemWriter<>();
        writer.setDelegates(Arrays.asList(jdbcUpdateTable1Writer, jdbcInsertTable2Writer));
        return writer;
    }

    @Bean
    public Job importDataJob(JobCompletionNotificationListener listener) {
        return new JobBuilder("importDataJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(step1())
                .next(step2())
                .build();
    }

    @Bean
    public Step step1() {
        return new StepBuilder("step - loading data into database", jobRepository)
                .<ProductCSV, ProductCSV>chunk(chunkSize, transactionManager)
                .reader(reader())
                .processor(processor)
                .writer(compositeItemWriter(stepWriter1(), stepWriter2(), stepWriter3()))
                .build();
    }

    @Bean
    public Step step2() {
        return new StepBuilder("step - database table connection", jobRepository)
                .<ProductCSV, ProductCSV>chunk(chunkSize, transactionManager)
                .reader(reader())
                .processor(processor)
                .writer(compositeItemConnector(stepConnect1(), stepConnect2()))
                .build();
    }
}
