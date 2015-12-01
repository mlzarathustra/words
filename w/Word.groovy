package w

class Word {
    Random random=new Random()

    String txt
    Word prev, next
    def others=[] as List<Word>

    String prevKey, nextKey

    String toString() { "[${prev?.txt}< $txt >${next?.txt}]"}
    Word getOneHopNext() {
        others[random.nextInt(others.size())].next
    }

    // prevKey - drops last word. nextKey - drops 1st word
    void setUpKeys() {
        String fullKey=Chain.toString(this,Common.chainLength).trim()
        prevKey = fullKey.replaceFirst(/\s+\w+$/,'')
        nextKey = fullKey.replaceFirst(/^\w+\s+/,'')
        println fullKey
        println "   prev: $prevKey"
        println "   next: $nextKey"
    }


    Word getChainedNext() {
        if (prevKey==null) setUpKeys()
        null
    }


}
