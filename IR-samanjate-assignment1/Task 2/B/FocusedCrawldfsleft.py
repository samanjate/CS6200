import urlparse
import urllib
import time
from bs4 import BeautifulSoup

#returns the seed url
def getSeedUrl():
    userurl = raw_input('Enter a URL: ')
    return userurl

def getKeyword():
    keyword = raw_input('Enter Keyword: ')
    return keyword


#function that returns true iff the conditions are met as specified in question
def checkCond(tagvalue):
    if tagvalue.startswith("/wiki/"):
        if (not tagvalue.__contains__(":")):
            if (not tagvalue.__contains__("Main_Page")):
                return True
    else:
        return False

url = getSeedUrl()
userkeyword = getKeyword()
urls = [url]   #a list implemented as a queue which stores the urls
visited = [url] #a list which stores the pages already crawled
urlsss = open('ir-samanjate-q2-B.txt', 'a') # the urls are stored in this file
urlsss.write(url + '\n')
urlwrite = 1 # counter that limits the urls in file to 1000

def getUrls (surl, d):
    global depth, urlwrite
    try:
        time.sleep(1) #politeness policy
        htmltext = urllib.urlopen(surl).read()
    except:
        err = open('error.txt', 'w')
        err.write(surl)
        err.close()

    #using BeautifulSoup to parse the html page
    soup = BeautifulSoup(htmltext, "html.parser") #gets the source code of the page
    for tag in soup.findAll('a', href=True):
        if checkCond(tag['href']):
            tag['href'] = urlparse.urljoin(url,tag['href'])
            if tag['href'].__contains__("#"): #properly treating URLs with #
                tag['href'] = tag['href'].split("#")[0]
            #only unique URLs are allowed in the urls list and 1000 URLs are saved
            if tag['href'] not in urls and urlwrite < 1000:
                if tag['href'].lower().__contains__(userkeyword):
                    urlsss.write(tag['href']+ '\n')
                    urls.append(tag['href'])
                    urlwrite = urlwrite + 1
                    visited.append(tag['href'])
                    if d == 6:
                        continue
                    getUrls(tag['href'], d + 1)

getUrls(url, 0)
urlsss.close()
print('Crawl Successful')
