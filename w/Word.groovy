package w

class Word {
    Random random=new Random()

    String txt
    Word prev, next
    def others=[] as List<Word>

    String toString() { "[${prev?.txt}< $txt >${next?.txt}]"}
    Word getMarkovNext() {
        others[random.nextInt(others.size())].next
    }
}
