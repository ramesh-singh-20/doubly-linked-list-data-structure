import com.alphacoder.datastructure.LinkedList
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

    def 'Test LinkedList | isEmpty() | LinkedList is not empty'(){
        given:
        def list= new LinkedList();
        list.insert(4,0)

        when:
        def result= list.isEmpty();

        then:
        result== false;

    }

    def 'Test LinkedList | size() | LinkedList is not empty'(){
        given:
        def list= new LinkedList();
        list.insert(4,0)

        when:
        def result= list.size()

        then:
        result== 1;

    }

    def 'Test LinkedList | insert() | IndexOutOfBoundException with -ve index'(){
        given:
        def list= new LinkedList();

        when:
        list.insert(2,-1)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def 'Test LinkedList | insert() | IndexOutOfBoundException with invalid index'(){
        given:
        def list= new LinkedList();

        when:
        list.insert(2,1)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def 'Test LinkedList | insert() | insert multiple elements at the start'(){
        given:
        def list= new LinkedList();

        when:
        list.insert(2,0)
        list.insert(3,0)
        list.insert(5, 0)

        then:
        list.isEmpty()== false
        list.size()== 3

        and:
        list.get(0)== 5
        list.get(1)== 3
        list.get(2)== 2
    }

    def 'Test LinkedList | insert() | insert multiple elements at the end'(){
        given:
        def list= new LinkedList();

        when:
        list.insert(2,list.size())
        list.insert(3, list.size())
        list.insert(5, list.size())
        list.insert(7, list.size())

        then:
        list.isEmpty()== false
        list.size()== 4

        and:
        list.get(0)== 2
        list.get(1)== 3
        list.get(2)== 5
        list.get(3)== 7
    }
}
