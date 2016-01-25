package w

class Word {
    Random random=new Random()
    boolean D=false

    String txt
    Word prev, next
    def others=[] as List<Word>
    def possibleNext=[] as List<Word> // accounting for chain

    String key

    String toString() { "[${prev?.txt}< $txt >${next?.txt}]"}
    Word getOneHopNext() {
        others[random.nextInt(others.size())].next
    }

    String getKey() {
        if (key==null) {
            key = Chain.toString(this, Common.chainLength).trim()
        }
        key
    }

    Word getChainedNext() {
        if (!possibleNext) {
            possibleNext = others.findAll { w-> key == w.key }
        }
        return possibleNext[random.nextInt(possibleNext.size())].next
    }
}
