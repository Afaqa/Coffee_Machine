class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        this.minutes++;
        this.hours += this.minutes / 60;
        this.minutes %= 60;
        this.hours = (this.hours - 1) % 12 + 1;
    }
}