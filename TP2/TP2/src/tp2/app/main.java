package app;

import java.time.LocalDate;

public class main {
        public static void main(String[] args){

            TipoDocumento helia = TipoDocumento.CUC;
            LocalDate dataValidade = null;


            TipoDocumento fredy = TipoDocumento.BI;
            LocalDate dataCarregamento= LocalDate.of(2021,07,3);
            DocumentoID documento1= new DocumentoID("1993", fredy);

            EpassStudent Student= new EpassStudent(70, 80.0, dataCarregamento, dataValidade,
                    12,"escola Técnica" );
            EpassStudent Student2= new EpassStudent(200.0, 40.0, dataCarregamento, dataValidade, Student);



            Student_8.checkValidade();
            Student.checkValidade();

        }
    }


}
