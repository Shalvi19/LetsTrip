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
Header=[]
Information=[]
for x in Titles:
    Header.append(x.get_text())
for x in Info:
    Information.append(x.get_text())

df=pd.DataFrame(Header)
df1=pd.DataFrame(Information)
df.to_csv('Places.csv')
df1.to_csv('Places1.csv')
