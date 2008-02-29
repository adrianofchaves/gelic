/******************************************************************************/
/***          Generated by IBExpert 2005.08.02 29/2/2008 13:56:57           ***/
/******************************************************************************/

SET SQL DIALECT 3;

SET NAMES NONE;

SET CLIENTLIB 'd:\adriano\servidor\fbclient.dll';

CREATE DATABASE 'LOCALHOST:D:\Adriano\Documentos\NetBeansProjects\Estacio\ProFin\bd\gelic.fdb'
USER 'SISGELIC' PASSWORD 'gelic'
PAGE_SIZE 16384
DEFAULT CHARACTER SET NONE;



/******************************************************************************/
/***                                 Tables                                 ***/
/******************************************************************************/



CREATE TABLE PAPEIS (
    ID    INTEGER NOT NULL,
    NOME  VARCHAR(25)
);

CREATE TABLE USUARIOS (
    LOGIN  VARCHAR(25) NOT NULL,
    SENHA  VARCHAR(40),
    PAPEL  INTEGER
);



/******************************************************************************/
/***                              Primary Keys                              ***/
/******************************************************************************/

ALTER TABLE PAPEIS ADD CONSTRAINT PK_PAPEIS PRIMARY KEY (ID);
ALTER TABLE USUARIOS ADD CONSTRAINT PK_USUARIOS PRIMARY KEY (LOGIN);


/******************************************************************************/
/***                              Foreign Keys                              ***/
/******************************************************************************/

ALTER TABLE USUARIOS ADD CONSTRAINT FK_USUARIOS_1 FOREIGN KEY (PAPEL) REFERENCES PAPEIS (ID) ON UPDATE CASCADE;
