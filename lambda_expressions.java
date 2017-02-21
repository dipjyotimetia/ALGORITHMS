//Before Java 8,we used to sort list using anonymous Comparator

List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

Collections.sort(names, new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return b.compareTo(a);
    }
});

//In java 8,lambda expressions  are introduced,and the same functionality
//can  be achieved  writing shorter  code

Collections.sort(names, (String a, String b) -> {
    return b.compareTo(a);
});

//and further shorter
Collections.sort(names, (String a, String b) -> b.compareTo(a));

//and further shorter
Collections.sort(names, (a, b) -> b.compareTo(a));



//
List<String> myList =
    Arrays.asList("a1", "a2", "b1", "c2", "c1");

myList
    .stream()                            //Creates a stream from list
    .filter(s -> s.startsWith("c"))      //Filters stream starting with "c"         
    .map(String::toUpperCase)            //converts to uppercase
    .sorted()                            //Sorts 
    .forEach(System.out::println);       //Prints


//
Arrays.asList("a1", "a2", "a3")
    .stream()
    .findFirst()                       //takes first element
    .ifPresent(System.out::println);  // a1

//
    IntStream.range(1, 4)    //generates a stream of 1,2,3(excluding 4)

//
    Arrays.stream(new int[] {1, 2, 3})    //creates stream
    .map(n -> 2 * n + 1)                  //converts each number
    .average()                            //Takes average(double)
    .ifPresent(System.out::println);  // 5.0

//
    Stream.of("a1", "a2", "a3")
    .map(s -> s.substring(1))            //removes string at index=1
    .mapToInt(Integer::parseInt)         //converts to int
    .max()
    .ifPresent(System.out::println);  // 3

//
    Stream.of(1.0, 2.0, 3.0)
    .mapToInt(Double::intValue)    //ntValue of Double class
    .mapToObj(i -> "a" + i)      
    .forEach(System.out::println);

//   VERY VERY IMPORTANT LEARN THIS

    Map<Integer, List<Person>> personsByAge = persons
    .stream()
    .collect(Collectors.groupingBy(p -> p.age));     //grouping by Persons by age 

personsByAge
    .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

// age 18: [Max]
// age 23: [Peter, Pamela]
// age 12: [David]

//Find averageAge using Collectors.averagingInt(predicate)

    Double averageAge = persons
    .stream()
    .collect(Collectors.averagingInt(p -> p.age));
	System.out.println(averageAge);     // 19.0		

// AWESOME JAVA 8

	IntSummaryStatistics ageSummary =
    persons
        .stream()
        .collect(Collectors.summarizingInt(p -> p.age));

System.out.println(ageSummary);
// IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}

//

//

String phrase = persons
    .stream()
    .filter(p -> p.age >= 18)     //["Max", "Peter"]
    .map(p -> p.name)
    .collect(Collectors.joining(" and ",       "In Germany ", " are of legal age."));
                                  ^delimiter    ^Prefix         ^Suffix
System.out.println(phrase);
// In Germany Max and Peter and Pamela are of legal age.

