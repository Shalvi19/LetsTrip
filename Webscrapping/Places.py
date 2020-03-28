from urllib.request import urlopen as uReq
from bs4 import BeautifulSoup as soup
import pandas as  pd


my_url = "https://www.treebo.com/blog/places-to-visit-in-jaipur/"
uClient = uReq(my_url)
page_html = uClient.read()
uClient.close()
page_soup = soup(page_html, "html.parser")
Titles = page_soup.find_all(attrs={"class":"ez-toc-section"})
Info = page_soup.find_all("ul", limit=29)

for x in Titles:
    print(x.get_text())
for x in Info:
     print(x.get_text())

filename="place.csv"
f= open(filename,"w",encoding='UTF-8')
headers="Titles, Info \n"
f.write(headers)
