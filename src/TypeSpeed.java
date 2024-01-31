public class TypeSpeed {
    private final String text;
    private final int textLength;
    private StringBuilder input;
    private int errors;
    private double accuracy;
    private long startTime;
    private long endTime;
    private boolean completed = true;

    public TypeSpeed(String text) {
        this.text = text;
        this.textLength = text.replaceAll("\\s", "").length();
    }

    public void startTest() {
        System.out.println(Colors.yellow() + "Type the text as fast as you can\nPress [ENTER] to finish\n----------\n" + Colors.green() + text + Colors.reset() + "\n");
        input = new StringBuilder();
        errors = 0;
        accuracy = 0;
        startTime = System.currentTimeMillis();
        handleInput();
        endTime = System.currentTimeMillis();
        displayResults();
    }

    private void handleInput() {
        int nextChar;
        int index = 0;
        try {
            while ((nextChar = System.in.read()) != '\n') {
                if (input.toString().length() >= text.length()) {
                    continue;
                } else {
                    if (nextChar == '\b') {
                        if (!input.isEmpty()) {
                            input.deleteCharAt(input.length() - 1);
                        }
                    } else {
                        input.append((char) nextChar);
                        updateAccuracyAndErrors(index);
                    }
                }
                index++;
            }
            System.out.println("----------");
        } catch (Exception e) {
            System.out.println(Colors.red() + "ERROR:" + e + Colors.reset() + "\n");
        }
    }

    private void updateAccuracyAndErrors(int index) {
        if (text.charAt(index) != input.charAt(index)) {
            errors++;
        }
        accuracy = (textLength - errors) / (double) textLength * 100;
        if (accuracy <= 0) {
            System.out.println(Colors.red() + "Learn to Type" + Colors.reset());
            System.exit(1);
        }
    }

    private void displayResults() {
        long timeTaken = endTime - startTime;
        int typingSpeed = textLength / ((int) timeTaken / 1000) * 60;
        int completedPercentage = (int) Math.round((input.toString().replaceAll("\\s", "").length()) * 100.0 / textLength);
        if (completedPercentage != 100) {
            completed = false;
        }


        System.out.println(Colors.magenta() + "Time taken: " + timeTaken / 1000 + " seconds");
        System.out.println("Typing speed: " + typingSpeed + " characters per minute");
        if (completed) {
            System.out.println("Accuracy: " + Math.round(accuracy * 100.0) / 100.0 + "%" + Colors.reset());
        }
        else {
            System.out.println("Accuracy: " + Math.round(accuracy * 100.0) / 100.0 + "%" + Colors.reset());
            System.out.println(Colors.red() + "Only Completed: " + completedPercentage + "%");
        }
    }
}
