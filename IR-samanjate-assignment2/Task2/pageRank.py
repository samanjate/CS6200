import math
import operator

M_inlinks = {} #set of pages that link to the page i.e the key
L_outlinks = {} #set of pages that the key page links to
P_outlinks = [] #set pages that have outlinks
s_nodes = [] # set of sink nodes
d = 0.85 #damping/teleportation factor
PR = {} #the PR score for each pages
newPR = {} #the new PR score for each page in every iteration
p = [] #set of all pages
N = 0 #number of pages in the corpus

def load_inlinks():
    with open("G1.txt") as f:
        for line in f:
            pages = line.split()
            if len(pages) > 1:
                M_inlinks[pages[0]] = pages[1:]
            else:
                M_inlinks[pages[0]] = []

def load_outlinks():
    for page in p:
        L_outlinks[page] = []
    for page in p:
        for pg in M_inlinks[page]:
            L_outlinks[pg].append(page)

def load_initial_PR():
    for page in p:
        PR[page] = 0

def load_sink_nodes():
    for page in p:
        if len(L_outlinks[page]) == 0:
            s_nodes.append(page)

def load_p_outlinks():
    for page in p:
        if len(L_outlinks[page]) != 0:
            P_outlinks.append(page)

def pageRank():
    for pg in p:
        PR[pg] = 1.0/N
    #print(perplexity())
    counter = 0
    perplexityfile = open('G1Perplexity.txt', 'w')
    while True:
        old = perplexity()
        perplexityfile.write(str(old)+'\n')
        sinkPR = 0
        for page in s_nodes:
            sinkPR += PR[page]
        for pge in p:
            newPR[pge] = (1.0-d)/N
            newPR[pge] += (d * sinkPR/N)
            for qr in M_inlinks[pge]:
                newPR[pge] += d * PR[qr]/len(L_outlinks[qr])
        for pgss in p:
            PR[pgss] = newPR[pgss]
        new = perplexity()
        if abs(old-new) > 1: #
            counter = 0
        if abs(old-new) < 1:
            counter = counter + 1
            if counter > 4:
                break
    perplexityfile.close()

def perplexity():
    h = 0
    for x in PR:
        h += PR[x]*(math.log(PR[x])/math.log(2))
    return math.pow(2,-h)

if __name__ == '__main__':

    print('loading memory')

    load_inlinks()

    p = M_inlinks.keys()
    N = len(p)

    load_outlinks()
    load_initial_PR()
    load_sink_nodes()
    load_p_outlinks()

    print('loaded')

    pageRank()
    sort_pr = sorted(PR.items(), key=operator.itemgetter(1),reverse=True)
    pagerankfile = open('G1PRscore.txt', 'w') # the urls are stored in this file
    writeinfile = 0
    for i in sort_pr:
        if writeinfile < 50:
            pagerankfile.write(str(i[0])+ " " + str(i[1]) +'\n')
            writeinfile += 1
    pagerankfile.close()

    print('end')
