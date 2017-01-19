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
urlsss = open('ir-samanjate-q2-A.txt', 'a') # the urls are stored in this file
urlsss.write(url+'\n')
urlwrite = 1 # counter that limits the urls in file to 1000

'''function that takes in a URL, opens the page, stores all the hrefs in the
a tags of the page and appends them to a global list urls
This function returns the number of urls found on that page'''
def getUrls (surl):
    try:
        htmltext = urllib.urlopen(surl).read()
    except:
        err = open('error.txt', 'w')
        err.write(surl)
        err.close()
    global urlwrite
    numUrls = 1

    #using BeautifulSoup to parse the html page
    soup = BeautifulSoup(htmltext, "html.parser") #gets the source code of the page
    for tag in soup.findAll('a', href=True):
        if checkCond(tag['href']):
            tag['href'] = urlparse.urljoin(url,tag['href'])
            if tag['href'].__contains__("#"):  #properly treating URLs with #
                tag['href'] = tag['href'].split("#")[0]
            #only unique URLs are allowed in the urls list and 1000 URLs are saved
            if tag['href'] not in visited and urlwrite < 1000:
                if tag['href'].lower().__contains__(userkeyword):
                    urlsss.write(tag['href']+'\n')
                    urlwrite = urlwrite + 1
                    urls.append(tag['href'])
                    visited.append(tag['href'])
                    numUrls = numUrls + 1
    urls.pop(0) #removes already crawled page
    return numUrls

'''funtion to start the web crawler'''
def WebCrawler():
    depth = 1
    counter = getUrls(urls[0])
    time.sleep(1) #politeness policy
    totalurls = counter
    depth = depth + 1
    while depth <= 5 and urlwrite < 1000:
        counter = 0
        while totalurls > 0 and urlwrite < 1000 and urls:
            counter = getUrls(urls[0]) + counter
            time.sleep(1) #politeness policy
            totalurls = totalurls - 1
            if totalurls == 0:
                totalurls = counter
                break
        depth = depth + 1

WebCrawler()
urlsss.close()
print('Crawl Successful')
