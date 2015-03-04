package panshul.learning.concepts;

public class PassByValue
{
    public static void main(String[] args)
    {
        Dog myDog = new Dog("Rover");
        foo(myDog);
        System.out.println("Name of myDog: " + myDog.getName());
    }

    /**
     * The value of variable myDog is passed, that is the memory location of myDog which has the value
     * Rover, as stated by the first sout statement.
     * In the second statement, the set method of the object stored at location held in someDog is
     * called and the now this memory location value is updated to Max. The myDog variable is also
     * pointing to the same memory location, so its value is also changed to the Max, as confirmed by
     * the last sout statement in the main method.
     * The statement in foo method -> someDog = new Dog("Fifi") assigns a new memory location to the
     * variable someDog.
     * @param someDog
     */
    private static void foo(Dog someDog)
    {
        System.out.println("Just entered method foo: " + someDog.getName());
        someDog.setName("Max");
        System.out.println("Name set to Max: " + someDog.getName());
        someDog = new Dog("Fifi");
        System.out.println("New Dog Object with Fifi " + someDog.getName());
        someDog.setName("Rowlf");
        System.out.println("Name set to Rowlf: " + someDog.getName());

    }

    public static class Dog
    {
        String name;

        public Dog(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }
    }

}

