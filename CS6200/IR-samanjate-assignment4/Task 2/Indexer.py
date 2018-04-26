import glob
import os
import operator

inverted_index = {}
term_frequency = {}
document_equivalent = {}

def loadTermsUnigram(file_name):
    terms_in_file = []
    with open(file_name) as f:
        for term in f:
            terms_in_file.append(term.split('\n')[0])
    return terms_in_file

def generateNGram(terms_for_processing,inverted_index,doc_ID):
    for term in terms_for_processing:
        if term not in inverted_index:
            inverted_index[term] = {}
        if doc_ID not in inverted_index[term]:
            inverted_index[term][doc_ID] = 1
        else:
            inverted_index[term][doc_ID] += 1

def writeNGramInFile(filename,inverted_index):
    inverted_index_file = open(filename, 'w')
    for term in inverted_index:
        inverted_index_file.write(term + " -> ")
        for doc_ID in inverted_index[term]:
            inverted_index_file.write("(" + str(doc_ID) + ", " + str(inverted_index[term][doc_ID]) + ") ")
        inverted_index_file.write("\n")
    inverted_index_file.close()

def print_doc_eq(document_equivalent,filename):
    sort_pr = sorted(document_equivalent.items(), key=operator.itemgetter(1))
    f = open(filename,'w')
    for i in sort_pr:
        f.write(str(i[1])+ " -> " + str(i[0]) +'\n')
    f.close()

if __name__ == '__main__':
    path = 'Tokenized pages/'
    doc_ID = 1
    for file_name in glob.glob(os.path.join(path, '*.txt')):
        terms_for_processing_unigram = loadTermsUnigram(file_name)
        filename = file_name.split('.txt')[0].split('/')[1]
        #Task 2
        generateNGram(terms_for_processing_unigram,inverted_index,doc_ID)
        document_equivalent[filename] = doc_ID
        doc_ID += 1

    writeNGramInFile("inverted_index.txt",inverted_index)

    print_doc_eq(document_equivalent,"Docs.txt")
