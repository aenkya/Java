public class Tables  {
    
    public void generateTable()  
    {
        //Put the code for your times-table here
        
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 12; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    public static void main (String args[]) {
        Tables t = new Tables();
        t.generateTable();
    }
}
