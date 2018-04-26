doc_to_docID = {}

with open('Docs.txt') as f:
    for line in f:
        docs = line.split()
        doc_to_docID[docs[2]] = docs[0]

for query_ID in xrange(1,5):
    with open('document_rank_for_query_'+ str(query_ID)+'.txt') as f:
        f2 = open('document_rank_for_query_'+ str(query_ID)+'_with_docID.txt','w')
        for line in f:
            elements = line.split()
            f2.write(elements[0]+' '+elements[1]+' '+doc_to_docID[elements[2]]+' '+elements[3]\
            +' '+elements[4]+' '+elements[5]+'\n')
        f2.close()
