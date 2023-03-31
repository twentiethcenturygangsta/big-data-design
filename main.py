from api import API
import ExportCSV


topics = [
    "자전거", "유모차", "청소기", "제습기", "선반", "책상", "의자", "전자렌지", "tv", "킥보드",
    "아이폰", "냉장고", "가방", "목걸이", "갤럭시", "시계", "침낭", "밥솥", "후드티", "커피",
    "다시마", "고추장", "인형", "세탁기", "옷걸이", "신발", "침대", "노트북", "커피", "음료",
    "감자", "고구마", "간장", "고기", "과자", "선", "식물", "취미", "공부", "책"
]

datas = []
for topic in topics:
    datas += API.get_products("http://openapi.11st.co.kr/openapi/OpenApiService.tmall", topic, 100, 50)
ExportCSV.make_datas_to_csv(datas)
print(datas)
