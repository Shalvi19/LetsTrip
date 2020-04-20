from urllib.request import urlopen as uReq
from bs4 import BeautifulSoup as soup
import pandas as  pd


my_url = "https://traveltriangle.com/blog/shopping-places-in-jaipur/"
uClient = uReq(my_url)
page_html = uClient.read()
uClient.close()
page_soup = soup(page_html, "html.parser")
#Titles = page_soup.find_all(attrs={"class":"ez-toc-section"})
headers = page_soup.find_all("h3", limit=17)
Info= page_soup.find_all("p")
Header=[]
Information=[]
for p in Info:
     Header.append(p.get_text())

for h in headers:
    Information.append(h.get_text())
df=pd.DataFrame(Header)
df1=pd.DataFrame(Information)
df.to_csv('Shopping.csv')
df1.to_csv('Shopping1.csv')