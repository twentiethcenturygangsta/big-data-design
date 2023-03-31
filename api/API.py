import requests
import xmltodict
from configuration import API_SECRET_KEY

API_CODE = "ProductSearch"


def get_products(url: str, search_keyword: str, page_size: int, page_num: int) -> list:
    datas = []
    for i in range(1, page_num+1):

        params = {
            "key": API_SECRET_KEY,
            "apiCode": API_CODE,
            "keyword": search_keyword,
            "pageSize": page_size,
            "pageNum": i
        }
        products = requests.get(url, params=params)
        if len(products.text) > 100:
            result = xmltodict.parse(products.text)

            datas += result["ProductSearchResponse"]["Products"]["Product"]
            print("keyword: ", search_keyword, " Num: ", i)
    return datas


