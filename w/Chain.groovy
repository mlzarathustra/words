package w

class Chain {
    Chain(w) { word=w; length=Common.chainLength }
    Chain(w,l) { word=w; length=l }
    Word word
    int length
    String string

    boolean isComplete() { isComplete(word, length-1) }
    static boolean isComplete(Word word, int length) {
        if (!word) return false
        if (length<=0) return true
        return isComplete(word.next, length-1)
    }

    String toString() {
        if (!string) string=toString(word,length)
        string
    }

    static String toString(Word word, int length) {
        if (!word || length<=0) return ''
        return "$word.txt ${ toString(word.next,length-1) }"
    }

    // does this word plus the ones following match this chain?
    boolean matches(Word w) { toString().equals(new Chain(w,length).toString()) }

    //  find all of the chains of the same length and same words
    def likeChains() {
        def rs = [this]
        word.others.each { Word w->
            if (w.is(word)) return
            if (matches(w)) rs << new Chain(w,length)
        }
        rs
    }


}
