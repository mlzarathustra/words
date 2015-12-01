package w

class Doc {
    def wordAry=[]

    Random random=new Random()

    Word getFirst() { wordAry[0] }
    Word getLast() { wordAry[-1] }
    Word getRandom() { wordAry[random.nextInt(wordAry.size())] }

    def getAt(int i) { wordAry[i] }  // operator []
    def size() { wordAry.size() }
    List each(Closure c) { wordAry.each(c) }


    Doc(String fileName) {
        File inp=new File(fileName)

        def ary = inp.getText().split(/\s+/).findAll { it =~ /\w/ }
                .collect { it.replaceAll(/^\W+|\W+$/, '').toLowerCase() }

        Word last = null
        def map = [:]
        ary.each {
            Word w = new Word(txt: it, prev: last)
            wordAry<<w
            if (last) {
                last.next = w
                w.prev = last
            }
            last = w

            def list = map[it]
            if (!list) {
                list = []; map[it] = list
            }
            list << w
        }

        //println map

        map.keySet().each {
            key ->
                def list = map[key]
                list.each { Word word -> word.others = list }
        }
    }
}