package medical_action_tracking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import patient_intake.Patient;



public class StudentCareTests {
    @Test 
    void testEmptyQueue() {
        LinkedQueue<String> queue = new LinkedQueue<>();
        assertNull(queue.dequeue());
        assertNull(queue.peekFront());
        assertEquals(0, queue.size());
    }

    @Test 
    void testSizeTest() {
        LinkedQueue<String> queue = new LinkedQueue<>();
        assertTrue(queue.checkSize());
        queue.enqueue("vehwif");
        assertTrue(queue.checkSize());
        for (int i=0;i<10;i++) queue.enqueue("cerf");
        assertTrue(queue.checkSize());
    }

    @Test 
    void testEmptyStack() {
        LinkedStack<String> stack = new LinkedStack<>();
        assertNull(stack.pop());
        assertNull(stack.peek());
        assertEquals(0, stack.size());
    }

    // Array queue tests
    @Test 
    void testEmptyArrayQueue() {
        ArrayQueue<String> aq = new ArrayQueue<>();
        assertNull(aq.dequeue());
        assertNull(aq.peek());
        assertTrue(aq.isEmpty());
        assertEquals(0, aq.size());
    }
    @Test 
    void testArrayQueueMethods() {
        ArrayQueue<String> aq = new ArrayQueue<>(5);
        aq.enqueue("One");
        aq.enqueue("Two");
        assertEquals(2, aq.size());
        aq.enqueue("Three");
        aq.enqueue("Four");
        aq.enqueue("Five");
        assertTrue(aq.isFull());
        try { aq.enqueue("Six"); }
        catch(IllegalArgumentException e) { assertEquals("Queue full", e.getMessage()); }
    }

    // Waiting room queue tests
    @Test 
    void testWaitingRoomQueueSize() {
        EmergencyWaitingRoom room = new EmergencyWaitingRoom();
        // Fill queue 1
        for (int i=0;i<3;i++) assertTrue(room.addPatient(new Patient(null, null, null, 0, null, 1, null, null, 0, null)));
        assertFalse(room.addPatient(new Patient(null, null, null, 0, null, 1, null, null, 0, null)));

        // queue 2
        for (int i=0;i<5;i++) assertTrue(room.addPatient(new Patient(null, null, null, 0, null, 2, null, null, 0, null)));
        assertFalse(room.addPatient(new Patient(null, null, null, 0, null, 2, null, null, 0, null)));
    }
    @Test 
    void testWaitingRoomFIFO() {
        EmergencyWaitingRoom room = new EmergencyWaitingRoom();
        room.addPatient(new Patient("P001", null, null, 0, null, 1, null, null, 0, null));
        room.addPatient(new Patient("P002", null, null, 0, null, 1, null, null, 0, null));
        assertEquals("P001", room.nextPatient().getPatientID());
        assertEquals("P002", room.nextPatient().getPatientID());
    }
    @Test 
    void testWaitingRoomPriority() {
        EmergencyWaitingRoom room = new EmergencyWaitingRoom();
        room.addPatient(new Patient("P001", null, null, 0, null, 1, null, null, 0, null));
        room.addPatient(new Patient("P002", null, null, 0, null, 1, null, null, 0, null));
        room.addPatient(new Patient("P003", null, null, 0, null, 2, null, null, 0, null));
        assertEquals(1, room.nextPatient().getTriageLevel());
        assertEquals(1, room.nextPatient().getTriageLevel());
        assertEquals(2, room.nextPatient().getTriageLevel());
    }
}