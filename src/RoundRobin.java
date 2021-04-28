/*
 * NAME: Bryan Talavera
 * PID: A14378593
 */

/**
 * This is an attempted implementation of the Round Robin Scheduling Algorithm
 *
 * @author Bryan Talavera
 * @since 04/25/21
 */
public class RoundRobin {

    /* constants */
    private static final String TASK_HANDLED = "All tasks are already handled.";
    private boolean HANDLED = false;
    private static final int DEF_QUANTUM = 4;


    /* instance variables */
    private DoublyLinkedList<Task> waitlist, finished;
    private int quantum, burstTime, waitTime, burstTimeTotal;

    /**
     * This is the constructor for our Round Robin Scheduling w/ default Quantum value
     * @param toHandle - The Task[] where all of our tasks are being held
     */
    public RoundRobin(Task[] toHandle) {
        if (toHandle == null) throw new IllegalArgumentException();
        this.waitlist = new DoublyLinkedList<>();
        this.finished = new DoublyLinkedList<>();
        this.quantum = DEF_QUANTUM;
        for (int i = 0; i < toHandle.length; i++) {
            this.waitlist.add(toHandle[i]);
        }
    }

    /**
     * This is our constructor for Round Robin Scheduling w/ customizable quantum value
     * @param quantum - The quantum time unit
     * @param toHandle - The array of tasks that need to be handled
     * @throws IllegalArgumentException if Quantum < 1; if toHandle is null; if no tasks passed in
     */
    public RoundRobin(int quantum, Task[] toHandle) throws IllegalArgumentException {
        if (quantum < 1) throw new IllegalArgumentException();
        if (toHandle == null) throw new IllegalArgumentException();
        this.quantum = quantum;
        this.waitlist = new DoublyLinkedList<>();
        this.finished = new DoublyLinkedList<>();
        for (int i = 0; i < toHandle.length; i++) {
            this.waitlist.add(toHandle[i]);
        }
    }

    /**
     * This method cycles through the tasks currently in our waitlist, then it schedules them
     * for one quantom period, after which the task is removed if completed or returns to the end
     * of the queue.
     * @return if the task was previously handled, the program will say so,
     * otherwise it will return the order of completion of our Tasks, alongside wait/burst time
     */
    public String handleAllTasks() {
        if (HANDLED) return TASK_HANDLED;
        DLLQueue<Task> taskDLLQueue = new DLLQueue<>();
        // Enqueueing our tasks to the task queue
        for (int i = 0; i < this.waitlist.size(); i++) {
            taskDLLQueue.enqueue(this.waitlist.get(i));
        }
        while (!(taskDLLQueue.isEmpty())) {
            burstTime = 0;
            int handledTasks = 0;
            // We handle our task when our task is incomplete and taskCounter value != quantum
            while (this.quantum != handledTasks && !(taskDLLQueue.peek().isFinished())) {
                // adding the size of our queue to total wait time
                waitTime += taskDLLQueue.size() - 1;
                // handling a task
                taskDLLQueue.peek().handleTask();
                // incrementing our taskCounter
                handledTasks += 1;
                burstTime += 1;
            }

            burstTimeTotal += burstTime;
            if (taskDLLQueue.peek().isFinished()){
                this.finished.add(taskDLLQueue.dequeue());
            } else {
                taskDLLQueue.enqueue(taskDLLQueue.dequeue());
            }
        }

        // String formatting
        String closingMessage = String.format("All tasks are handled within " +
                "%s units of burst time and " +
                "%s units of wait time.", burstTimeTotal, waitTime);

        closingMessage = closingMessage + new String("The tasks are finished in this order:\n");
        for (int i = 0; i < finished.size() - 1; i++) {
            closingMessage += new String (finished.get(i).toString() + " -> ");
        }
        closingMessage += finished.get(finished.size()-1).toString();
        HANDLED = true;
        return closingMessage;
    }


    /**
     * Main method for testing.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Task[] test1 = {new Task("A", 3), new Task("B", 4),
                        new Task("C", 4), new Task("D", 12),
                        new Task("E", 6), new Task("F", 3)};
        RoundRobin rr1 = new RoundRobin(3, test1);     // Quantum: 3, ToHandle: test1
        System.out.println(rr1.handleAllTasks());   // Burst: 32, Wait: 86, Order: AFBCED
        System.out.println();
        System.out.println(rr1.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test2 = {new Task("A", 9), new Task("B", 8),
                        new Task("C", 6), new Task("D", 4),
                        new Task("E", 4), new Task("F", 3)};
        RoundRobin rr2 = new RoundRobin(test2);  // Quantum: 4, ToHandle: test2
        System.out.println(rr2.handleAllTasks());   // Burst: 34, Wait: 123, Order: DEFBCA
        System.out.println();
        System.out.println(rr2.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test3 = {new Task("A", 7), new Task("B", 5),
                        new Task("C", 3), new Task("D", 1),
                        new Task("E", 2), new Task("F", 4),
                        new Task("G", 6), new Task("H", 8)};
        RoundRobin rr3 = new RoundRobin(3, test3);     // Quantum: 3, ToHandle: test3
        System.out.println(rr3.handleAllTasks());   // Burst: 36, Wait: 148, Order: CDEBFGAH
        System.out.println();
        System.out.println(rr3.handleAllTasks());   // TASK_HANDLED
        System.out.println();
    }
}