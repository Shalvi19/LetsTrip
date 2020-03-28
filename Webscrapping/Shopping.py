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
#for x in headers:
     #print(x.get_text())
#for x in Info:
    # print(x.get_text())
#filename="place.csv"
#f= open(filename,"w",encoding='UTF-8')
#headers="Titles, Info \n"
#f.write(headers)
#html=list(page_soup.children)[2]
#print(html)
data=[]
para=page_soup.find_all(attrs={"class":"blog-exerpt fb-heart"})
for p in Info:
     print(p.get_text())
