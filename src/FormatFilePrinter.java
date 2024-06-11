//попытка создать класс, который будет принимать строки из разных классов, объединять их и форматировать по ширине
public class FormatFilePrinter {
    private final String personData;
    private final String awardInformation;
    private final String eventInformation;
    String[] elements = new String[joinStringOfPersonDataAwardsAndEvent().length()];
    public FormatFilePrinter(String personData, String awardInformation, String eventInformation){
        this.personData = personData;
        this.awardInformation = awardInformation;
        this.eventInformation = eventInformation;
    }

    public String formatForString(){
        //joinStringOfPersonDataAwardsAndEvent();
        elements = splitStringOfAllInformationAboutPerson();
        return writeFile(elements);
    }

    public String joinStringOfPersonDataAwardsAndEvent(){
        return String.join(", ", personData, awardInformation, eventInformation);
    }

    public String[] splitStringOfAllInformationAboutPerson(){
        String str = joinStringOfPersonDataAwardsAndEvent();
        String[] split = str.split(", ");
        return split;
    }

    public static int findMaxLength(String[] elements) {
        int max = 0;
        for (String line : elements) {
            if (line.length() > max){
                max = line.length();
            }
        }
        return max;
    }

    public static String writeFile(String[] elements){
        String[] secondName = new String[elements.length];
        String[] firstName = new String[elements.length];
        String[] surName = new String[elements.length];
        String[] awards = new String[elements.length];
        String[] events = new String[elements.length];
        String[] split = new String[elements.length];
        int i = 0;
        for (String line : elements) {
            split = line.split(", ");
            secondName[i] = split[0];
            firstName[i] = split[1];
            surName[i] = split[2];
            awards[i] = split[3];
            events[i] = split[4];
            i++;
        }
        int secondNameLength = findMaxLength(secondName);
        int firstNameLength = findMaxLength(firstName);
        int surNameLength = findMaxLength(surName);
        int awardsLength = findMaxLength(awards);
        int eventLength = findMaxLength(elements);
        String str = null;
        for (int j = 0; j < secondNameLength; j++) {
            str = "%-" + surNameLength + "s %" + firstNameLength + "s %" + surNameLength + "s %" + awardsLength +
                    "s %" + eventLength + "s";
        }
        return str;
    }
}
