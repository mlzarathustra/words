package w

class Chain {
    Chain(w,l) { word=w; length=l }
    Word word
    int length

    boolean isComplete() { isComplete(word, length-1) }
    static boolean isComplete(Word word, int length) {
        if (!word) return false
        if (length<=0) return true
        return isComplete(word.next, length-1)
    }

    String toString() { toString(word,length) }

    static String toString(Word word, int length) {
        if (!word || length<=0) return ''
        return "$word.txt ${ toString(word.next,length-1) }"
    }


}
