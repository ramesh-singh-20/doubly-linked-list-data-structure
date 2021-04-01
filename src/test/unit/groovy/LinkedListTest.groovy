import spock.lang.Specification

class LinkedListTest extends Specification{

    def 'Test LinkedList | isEmpty() | LinkedList is empty'(){
        given:
        def list= new LinkedList();

        when:
        def result= list.isEmpty();

        then:
        result== true;

    }

    def 'Test LinkedList | size() | LinkedList is empty'(){
        given:
        def list= new LinkedList();

        when:
        def result= list.size()

        then:
        result== 0;

    }
}
