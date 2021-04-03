import com.alphacoder.datastructure.LinkedList
import spock.lang.Specification

class LinkedListTest extends Specification{

    def 'Test LinkedList | isEmpty() | LinkedList is empty'(){
        given:
        def list= new LinkedList()

        when:
        def result= list.isEmpty()

        then:
        result== true

    }

    def 'Test LinkedList | size() | LinkedList is empty'(){
        given:
        def list= new LinkedList()

        when:
        def result= list.size()

        then:
        result== 0

    }

    def 'Test LinkedList | isEmpty() | LinkedList is not empty'(){
        given:
        def list= new LinkedList()
        list.insert(4,0)

        when:
        def result= list.isEmpty()
        list.print()

        then:
        result== false

    }

    def 'Test LinkedList | size() | LinkedList is not empty'(){
        given:
        def list= new LinkedList()
        list.insert(4,0)

        when:
        def result= list.size()
        list.print()

        then:
        result== 1

    }

    def 'Test LinkedList | insert() | IndexOutOfBoundException with -ve index'(){
        given:
        def list= new LinkedList()

        when:
        list.insert(2,-1)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def 'Test LinkedList | insert() | IndexOutOfBoundException with invalid index'(){
        given:
        def list= new LinkedList()

        when:
        list.insert(2,1)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def 'Test LinkedList | insert() | insert multiple elements at the start'(){
        given:
        def list= new LinkedList()

        when:
        list.insert(2,0)
        list.insert(3,0)
        list.insert(5,0)

        then:
        list.isEmpty()== false
        list.size()== 3
        list.print()

        and:
        list.get(0)== 5
        list.get(1)== 3
        list.get(2)== 2
    }

    def 'Test LinkedList | insert() | insert multiple elements at the end'(){
        given:
        def list= new LinkedList()

        when:
        list.insert(2,list.size())
        list.insert(3, list.size())
        list.insert(5, list.size())
        list.insert(7, list.size())

        then:
        list.isEmpty()== false
        list.size()== 4
        list.print()

        and:
        list.get(0)== 2
        list.get(1)== 3
        list.get(2)== 5
        list.get(3)== 7
    }

    def 'Test LinkedList | insert() | insert multiple elements in between'(){
        given:
        def list= new LinkedList()
        list.insert(0, 0)
        list.insert(1, 1)
        list.insert(2, 2)

        when:
        list.insert(4,1)
        list.insert(7, 1)
        list.insert(8, 2)
        list.insert(9, 2)

        then:
        list.isEmpty()== false
        list.size()== 7
        list.print()

        and:
        list.get(0)== 0
        list.get(1)== 7
        list.get(2)== 9
        list.get(3)== 8
        list.get(4)== 4
        list.get(5)== 1
        list.get(6)== 2
    }

    def 'Test LinkedList | get() | IndexOutOfBoundException with -ve index'(){
        given:
        def list= new LinkedList()
        list.insert(1, 0)

        when:
        list.get(-1)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def 'Test LinkedList | get() | IndexOutOfBoundException with invalid index'(){
        given:
        def list= new LinkedList()
        list.insert(1, 0)
        list.insert(1, 0)
        list.insert(1, 0)

        when:
        list.get(3)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def 'Test LinkedList | delete() | IndexOutOfBoundException with -ve index'(){
        given:
        def list= new LinkedList()
        list.insert(1, 0)
        list.insert(1, 0)

        when:
        list.delete(-1)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def 'Test LinkedList | delete() | IndexOutOfBoundException with invalid index'(){
        given:
        def list= new LinkedList()
        list.insert(1, 0)
        list.insert(1, 0)

        when:
        list.delete(2)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def 'Test LinkedList | delete() | delete elements from the start'(){
        given:
        def list= new LinkedList()
        list.insert(1, 0)
        list.insert(2, 1)
        list.insert(3, 2)
        list.insert(4, 3)

        when:
        list.delete(0)
        list.delete(0)
        list.delete(0)
        list.delete(0)

        then:
        list.isEmpty()== true
        list.size()== 0

    }

    def 'Test LinkedList | delete() | delete elements from the end'(){
        given:
        def list= new LinkedList()
        list.insert(1, 0)
        list.insert(2, 1)
        list.insert(3, 2)
        list.insert(4, 3)

        when:
        list.delete(list.size()-1)
        list.delete(list.size()-1)
        list.delete(list.size()-1)
        list.delete(list.size()-1)

        then:
        list.isEmpty()== true
        list.size()== 0
    }

    def 'Test LinkedList | delete() | delete elements in between'(){
        given:
        def list= new LinkedList()
        list.insert(1, 0)
        list.insert(2, 1)
        list.insert(3, 2)
        list.insert(4, 3)

        when:
        list.delete(2)
        list.delete(1)
        list.delete(1)

        then:
        list.isEmpty()== false
        list.size()== 1

        and:
        list.get(0)== 1
    }

    def 'Test LinkedList | update() | update elements at the start'(){
        given:
        def list= new LinkedList()
        list.insert(1, 0)
        list.insert(2, 1)
        list.insert(3, 2)
        list.insert(4, 3)

        when:
        list.update(5, 0)

        then:
        list.isEmpty()== false
        list.size()== 4

        and:
        list.get(0)== 5
        list.get(1)== 2
        list.get(2)== 3
        list.get(3)== 4
    }

    def 'Test LinkedList | update() | update elements at the end'(){
        given:
        def list= new LinkedList()
        list.insert(1, 0)
        list.insert(2, 1)
        list.insert(3, 2)
        list.insert(4, 3)

        when:
        list.update(5, 3)

        then:
        list.isEmpty()== false
        list.size()== 4

        and:
        list.get(0)== 1
        list.get(1)== 2
        list.get(2)== 3
        list.get(3)== 5
    }

    def 'Test LinkedList | update() | update elements in the middle'(){
        given:
        def list= new LinkedList()
        list.insert(1, 0)
        list.insert(5, 1)
        list.insert(6, 2)
        list.insert(4, 3)

        when:
        list.update(5, 3)

        then:
        list.isEmpty()== false
        list.size()== 4

        and:
        list.get(0)== 1
        list.get(1)== 5
        list.get(2)== 6
        list.get(3)== 5
    }

    def 'Test LinkedList | printRecursively() |'(){
        given:
        def list= new LinkedList()
        list.insert(1, 0)
        list.insert(5, 1)
        list.insert(6, 2)
        list.insert(4, 3)

        when:
        System.out.println()
        list.printRecursively(list.getHead())

        then:
        list.isEmpty()== false
        list.size()== 4

        and:
        list.get(0)== 1
        list.get(1)== 5
        list.get(2)== 6
        list.get(3)== 4
    }

    def 'Test LinkedList | printReverseRecursively() |'(){
        given:
        def list= new LinkedList()
        list.insert(1, 0)
        list.insert(5, 1)
        list.insert(6, 2)
        list.insert(4, 3)

        when:
        list.printReversRecursively(list.getHead())

        then:
        list.isEmpty()== false
        list.size()== 4

        and:
        list.get(0)== 1
        list.get(1)== 5
        list.get(2)== 6
        list.get(3)== 4
    }

    def 'Test LinkedList | printReverse() |'(){
        given:
        def list= new LinkedList()
        list.insert(1, 0)
        list.insert(5, 1)
        list.insert(6, 2)
        list.insert(4, 3)

        when:
        list.printReverse()

        then:
        list.isEmpty()== false
        list.size()== 4

        and:
        list.get(0)== 1
        list.get(1)== 5
        list.get(2)== 6
        list.get(3)== 4
    }

    def 'Test LinkedList | reverse() '(){
        given:
        def list= new LinkedList()
        list.insert(0, 0)
        list.insert(1, 1)
        list.insert(2, 2)
        list.insert(3, 3)
        list.print()

        when:
        list.reverse()
        list.print()

        then:
        !list.isEmpty()
        list.size()== 4

        and:
        list.get(0)== 3
        list.get(1)== 2
        list.get(2)== 1
        list.get(3)== 0


    }
}
