package ir.maktab.utils;

public class Logger extends Throwable implements LoggerApis {

   void msg()  {

       String message = getMessage();
       message= "\n"+message;
   }



    Logger(){
        super();
    }

}
