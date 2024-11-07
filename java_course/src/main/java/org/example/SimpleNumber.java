public class SimpleNumber {
    private String numbers = "";

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String findSimpleNumber(int p) {
        StringBuilder tempString = new StringBuilder();
        for (int i = p; i < 101; i++) {
            if (i == 2) {
                tempString.append(" ").append(i);
            }
            if (i % p == 0) {
                continue;
            } else {
                tempString.append(" ").append(i);
            }

        }
        setNumbers(tempString.toString());
        return getNumbers();
    }
}
