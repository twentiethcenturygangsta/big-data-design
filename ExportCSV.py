import csv


def make_datas_to_csv(datas: list) -> None:
    headers = ["id"] + list(datas[0].keys())
    index = 0
    f = open("out.csv", "w")
    writer = csv.writer(f)
    writer.writerow(headers)
    for data in datas:
        index += 1
        writer.writerow([index] + list(data.values()))
    f.close()


