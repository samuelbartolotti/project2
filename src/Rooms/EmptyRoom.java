package Rooms;

public class EmptyRoom extends Room{
   public EmptyRoom() {
       width = rnd(minLength, maxLength);
       length = rnd(minLength, maxLength);
   }


}
