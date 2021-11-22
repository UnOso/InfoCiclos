package com.polariumx.infociclos.sampleData;

import com.polariumx.infociclos.models.GradoModel;
import com.polariumx.infociclos.models.ModuloModel;

public class SampleData {
    public static GradoModel DAM1 = new GradoModel(
            "Desarrrollo de Aplicaciones Multiplataforma 1er año",
            new ModuloModel[]{
                    new ModuloModel("Base de datos","Manejo de datos desde una base de datos.", false),
                    new ModuloModel("Entornos de desarrollo","Funcionamiento de IDE.", false),
                    new ModuloModel("Formación y orientación laboral","Preparación para entrar al mercado laboral.", false),
                    new ModuloModel("Lenguaje de marcas y sistemas de gestión de información","Exposición a los diferentes lenguajes de marca en existencia.", false),
                    new ModuloModel("Programación","Bases de la programación y buenas practicas.", false),
                    new ModuloModel("Sistemas informaticós","Funcionamiento y estructura de un sistema informaticó.", false),
            }
    );

    public static GradoModel DAM2 = new GradoModel(
            "Desarrrollo de Aplicaciones Multiplataforma 2do año",
            new ModuloModel[]{
                    new ModuloModel("Acceso a datos","Manejo de datos.", false),
                    new ModuloModel("Desarrollo de interfaces","Diseño e implementacion de una interfaz.", false),
                    new ModuloModel("Empresa e iniciativa emprendedora","Preparación para ser empresario.", false),
                    new ModuloModel("Inglés técnico para grado superior","Ingles enfocado al grado.", false),
                    new ModuloModel("Programación de servicios y procesos","Manejo de procesos y uso correcto de servicios.", false),
                    new ModuloModel("Programación multimedia y dispositivos móviles","Desarrollo de aplicaciones en android.", false),
                    new ModuloModel("Sistemas de gestión empresarial","Programas para la gestion de una empresa.", false),
                    new ModuloModel("Proyecto de desarrollo de aplicaciones multiplataforma","Proyecto final de grado.", false),
                    new ModuloModel("FORMACIÓN EN CENTROS DE TRABAJO","Exposicion al mundo laboral durante 3 meses en una empresa del sector.", false),
            }
    );

    public static GradoModel DAW1 = new GradoModel(
            "Desarrrollo de Aplicaciones Web 1er año",
            new ModuloModel[]{
                    new ModuloModel("Base de datos","Manejo de datos desde una base de datos.", false),
                    new ModuloModel("Entornos de desarrollo","Funcionamiento de IDE.", false),
                    new ModuloModel("Formación y orientación laboral","Preparación para entrar al mercado laboral.", false),
                    new ModuloModel("Lenguaje de marcas y sistemas de gestión de información","Exposición a los diferentes lenguajes de marca en existencia.", false),
                    new ModuloModel("Programación","Bases de la programación y buenas practicas.", false),
                    new ModuloModel("Sistemas informaticós","Funcionamiento y estructura de un sistema informaticó.", false),
            }
    );

    public static GradoModel DAW2 = new GradoModel(
            "Desarrrollo de Aplicaciones Web 2do año",
            new ModuloModel[]{
                    new ModuloModel("Desarrollo web en entorno cliente","Desarrollo de aplicaciones Front End.", false),
                    new ModuloModel("Desarrollo web en entorno servidor","Manejo de informacion Back End.", false),
                    new ModuloModel("Despliegue de aplicaciones web","Correcta implementacion de la aplicacion web.", false),
                    new ModuloModel("Diseño de interfaces web","Diseño e implementacion de una interfaz.", false),
                    new ModuloModel("Empresa e iniciativa emprendedora","Preparación para ser empresario.", false),
                    new ModuloModel("Inglés técnico para grado superior","Ingles enfocado al grado.", false),
                    new ModuloModel("Proyecto de desarrollo de aplicaciones web","Proyecto final de grado.", false),
                    new ModuloModel("FORMACIÓN EN CENTROS DE TRABAJO","Exposicion al mundo laboral durante 3 meses en una empresa del sector.", false),
            }
    );
}
