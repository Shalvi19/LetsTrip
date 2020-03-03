from urllib.request import urlopen as uReq
from bs4 import BeautifulSoup as soup

my_url = "https://www.tripadvisor.in/Attraction_Review-g304555-d317345-Reviews-Hawa_Mahal_Palace_of_Wind-Jaipur_Jaipur_District_Rajasthan.html#REVIEWS"
uClient = uReq(my_url)
page_html = uClient.read()
uClient.close()
page_soup = soup(page_html, "html.parser")
commetns = page_soup.find_all(attrs={"class":"location-review-review-list-parts-ExpandableReview__reviewText--gOmRC"})
users = page_soup.find_all(attrs={"class":"ui_header_link social-member-event-MemberEventOnObjectBlock__member--35-jC"})

# print(containers)
for x in commetns:
    print(x.span.get_text())
# print()
