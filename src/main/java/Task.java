abstract class Task {
    protected String description;
    protected boolean isDone;
    protected TaskType type;

    public Task(String description, TaskType type) {
        this.description = description;
        this.isDone = false;
        this.type = type;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void markAsDone() {
        isDone = true;
    }

    public void markAsNotDone() {
        isDone = false;
    }

    public TaskType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[" + type.name().charAt(0) + "][" + getStatusIcon() + "] " + description;
    }
}
