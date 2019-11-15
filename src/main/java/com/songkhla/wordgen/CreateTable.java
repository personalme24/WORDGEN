/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import static com.songkhla.wordgen.ChargePage.ChargeCode;
import static com.songkhla.wordgen.ChargePage.ChargeName;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Computer
 */
public class CreateTable {
    	 public static void createNewTable() {
         
	        // SQLite connection string
	       Connection cc= ConnectDatabase.connect();
               
//             String url = "jdbc:sqlite:D://db/SR2.db";
	        String sqlLogin = "CREATE TABLE IF NOT EXISTS User (\n"+
                               "   IdUSer	INTEGER	Primary Key AUTOINCREMENT,	\n"+        
                               "   Username  VARCHAR(100)	,	\n"+
                               "   Password  VARCHAR(100)	,	\n"+ 
                               "   PeopleCard  VARCHAR(100)	,	\n"+
                               "   StatusLogin  VARCHAR(100)	,	\n"+
                               "   SerialNum  VARCHAR(100)	,	\n"+
                               "   Token  VARCHAR(100)	,	\n"+
                               "   DateLogin DATE		\n"+                        
                               "	); ";
                String sqlDataCharge = "CREATE TABLE IF NOT EXISTS DataCharge (\n"+
                               "   IdCaseCharge	INTEGER	Primary Key AUTOINCREMENT,	\n"+        
                               "   TypeCaseCharge  VARCHAR(100)	,	\n"+
                               "   ChargeUse  VARCHAR(100)	,	\n"+ 
                               "   DateToday DATE		\n"+                        
                               "	); ";
                String sqlDataForm = "CREATE TABLE IF NOT EXISTS DataForm (\n"+
                                  "   IdReport	INTEGER	Primary Key AUTOINCREMENT,	\n"+        
                               "   TypeCaseReport  VARCHAR(100)	,	\n"+
                               "   NameReport  VARCHAR(100)	,	\n"+ 
                               "   DateToday DATE		\n"+                         
                               "	); ";
                String sqlParameter = "CREATE TABLE IF NOT  EXISTS ParameterTable (\n"+
                               "   IdCaseForCrime	 VARCHAR(100)	,	\n"+        
                               "   CrimeNo  VARCHAR(100)	,	\n"+
                               "   CrimeYears  VARCHAR(100)	,	\n"+
                               "   org_code VARCHAR(100)	,	\n"+ 
                               "   CaseAcceptDateStart VARCHAR(100)	,	\n"+                        
                               "   CaseAcceptDateEnd VARCHAR(100)	\n"+                        

                               "	); ";
                String sqlHolidays = "CREATE TABLE IF NOT EXISTS Holidays (\n"+
                               "   IDHolidays	INTEGER	Primary Key AUTOINCREMENT,	\n"+        
                               "   HolidaysDate  VARCHAR(100)	,	\n"+
                               "   HolidaysName  VARCHAR(100)		\n"+                   
                               "	); ";
                String sqlAnswer= "CREATE TABLE IF NOT EXISTS Answer (\n"+
                               "   IdAnswer	INTEGER	Primary Key AUTOINCREMENT,	\n"+        
                               "   AnswerDetail  VARCHAR(500)	,	\n"+
                               "   AnswerTypePerson  VARCHAR(100)	,	\n"+
                               "   AnswerTypeCase VARCHAR(100)		\n"+                        
                               "	); ";
	        // SQL statement for creating a new table
	        String sqlPerson = "CREATE TABLE IF NOT EXISTS Person (\n"+
                "	NoPerson	INTEGER	Primary Key AUTOINCREMENT,	\n"+        
	        "	DateIdentify	DATE	,	\n"+
                "	PeopleRegistrationID	VARCHAR(13)	,	\n"+
                "	IssueDate	DATE	,	\n"+
                "	ExpiredDate	DATE	,	\n"+
                "	IssuedBy	VARCHAR(100)	,	\n"+
                "	PassportNumber	VARCHAR(100)	,	\n"+
                "	FullNamePerson	VARCHAR(100)	,	\n"+
                "	FullNamePersonEn	VARCHAR(100)	,	\n"+
                "	OtherName	VARCHAR(100)	,	\n"+
                "	OtherSurname	VARCHAR(100)	,	\n"+
                "	BirthDay	DATE	,	\n"+
                "	Gender	VARCHAR(100)	,	\n"+
                "	Age	VARCHAR(100)	,	\n"+
                "	Race	VARCHAR(100)	,	\n"+
                "	Nationality	VARCHAR(100)	,	\n"+
                "	Religion	VARCHAR(100)	,	\n"+
                "	Occupation	VARCHAR(100)	,	\n"+
                "	OccupationPosition	VARCHAR(100)	,	\n"+                        
                "	Height	VARCHAR(100)	,	\n"+
                "	Weight	VARCHAR(100)	,	\n"+
                "	BloodGroup	VARCHAR(100)	,	\n"+
                "	Related	VARCHAR(100)	,	\n"+
                "	RelatedAccused	VARCHAR(100)	,	\n"+                         
                "	HouseNumber	VARCHAR(100)	,	\n"+
                "	Moo	VARCHAR(100)	,	\n"+
                "	Tambon	VARCHAR(100)	,	\n"+
                "	Amphur	VARCHAR(100)	,	\n"+
                "	Province	VARCHAR(100)	,	\n"+
                "	ZipCode	VARCHAR(100)	,	\n"+
                "	PhonePerson	VARCHAR(100)	,	\n"+
                "	HeadmanName	VARCHAR(100)	,	\n"+
                "	SubHeadmanName	VARCHAR(100)	,	\n"+
                "	FatherFullName	VARCHAR(100)	,	\n"+
                "	MotherFullName	VARCHAR(100)	,	\n"+
                "	TambonBirthday	VARCHAR(100)	,	\n"+
                "	AmphurBirthday	VARCHAR(100)	,	\n"+
                "	ProvinceBirthday	VARCHAR(100)	,	\n"+
                "	NoImprison	VARCHAR(100)	,	\n"+
                "	CauseImprison	VARCHAR(100)	,	\n"+
                "	PlaceBorn	VARCHAR(100)	,	\n"+
                "	DeathLocation	VARCHAR(100)	,	\n"+
                "	TambomDie	VARCHAR(100)	,	\n"+
                "	AmphurDie	VARCHAR(100)	,	\n"+
                "	ProvinceDie	VARCHAR(100)	,	\n"+
                "	PlaceOfFoundBody	VARCHAR(100)	,	\n"+
                "	TambomFoundBody	VARCHAR(100)	,	\n"+
                "	AmphurFoundBody	VARCHAR(100)	,	\n"+
                "	ProvinceFoundBody	VARCHAR(100)	,	\n"+
                "	CircumstancesOfDeathPer	VARCHAR(100)	,	\n"+
                "	ArrestDate	VARCHAR(100)	,	\n"+
                "	ArrestTime	VARCHAR(100)	,	\n"+ 
                "	ControlDate	VARCHAR(100)	,	\n"+
                "	ControlTime	VARCHAR(100)	,	\n"+                                
                "	PlaceArrest	VARCHAR(100)	,	\n"+
                 "	PlaceArrestTambon	VARCHAR(100)	,	\n"+
                "	PlaceArrestAmphur	VARCHAR(100)	,	\n"+
                 "	PlaceArrestProvince	VARCHAR(100)	,	\n"+
                "	Country         VARCHAR(100)	,	\n"+
                "	DoctorCheckBodyID	VARCHAR(100)	,\n"+
                "	DoctorCheckBody	VARCHAR(100)	,	\n"+
                "	FatherAge	VARCHAR(100)	,	\n"+
                "	FatherCareer	VARCHAR(100)	,	\n"+
                "	FatherIdCard	VARCHAR(100)	,	\n"+
                "	FatherAddress	VARCHAR(100)	,	\n"+
                "	FatherPhone	VARCHAR(100)	,	\n"+
                "	MotherAge	VARCHAR(100)	,	\n"+
                "	MotherCareer	VARCHAR(100)	,	\n"+
                "	MotherIdCard	VARCHAR(100)	,	\n"+
                "	MotherAddress	VARCHAR(100)	,	\n"+
                "	MotherPhone	VARCHAR(100)	,	\n"+
                "	ParentName	VARCHAR(100)	,	\n"+                        
                "	ParentAge	VARCHAR(100)	,	\n"+
                "	ParentCareer	VARCHAR(100)	,	\n"+
                "	ParentIdCard	VARCHAR(100)	,	\n"+
                "	ParentAddress	VARCHAR(100)	,	\n"+
                "	ParentPhone	VARCHAR(100)	,	\n"+
                "	TypePerson	VARCHAR(100)	,	\n"+
                "	Office	VARCHAR(100)	,	\n"+
                "	SpouseFullName	VARCHAR(100)	,	\n"+
                "	Education	VARCHAR(100)	,	\n"+
                "	FriendAddress	VARCHAR(100)	,	\n"+
                "	FavouritePlace	VARCHAR(100)	,	\n"+
                "	Identification	VARCHAR(100)	,	\n"+
                "	AllVictim	VARCHAR(100)	,	\n"+
                "	DateOfDie	VARCHAR(100)	,	\n"+                        
                "	TimeOfDie	VARCHAR(100)	,	\n"+
                "	BodyFoundTime	VARCHAR(100)	,	\n"+
                "	BodyFoundDate	VARCHAR(100)	,	\n"+               
                "	RelatedOfDie	VARCHAR(100)	,	\n"+
                "	InterrogateDate	VARCHAR(100)	,	\n"+
                "	CurrentAddress	VARCHAR(100)	,	\n"+
                "	ArrestDateTime	VARCHAR(100)	,	\n"+
                "	ArrestDateTimeEnd	VARCHAR(100)	,	\n"+                   
                "	StatusSueAndPutInJail	VARCHAR(100)	,	\n"+
                "	StatusBail	VARCHAR(100)	,	\n"+
                "	RatePrison	VARCHAR(100)	,	\n"+                        
                "	NumberImprison	VARCHAR(100)	,	\n"+
                "	SinceImprison	VARCHAR(100)	,	\n"+
                "	SinceImprisonTime	VARCHAR(100)	,	\n"+
                "	ToImprison	VARCHAR(100)	,	\n"+
                "	ToImprisonTime	VARCHAR(100)	,	\n"+
                "	TotalDate	VARCHAR(100)	,	\n"+
                "	TotalTime	VARCHAR(100)	,	\n"+
                "	StatusSuspect	VARCHAR(100)	,	\n"+
                "	StatusSuspectOther	VARCHAR(100)	,	\n"+                        
                "	BailDate	VARCHAR(100)	,	\n"+
                "	RestoreDate	VARCHAR(100)	,	\n"+ 
                "	Road     	VARCHAR(100)	,	\n"+
                "	Soi     	VARCHAR(100)	,	\n"+
                "	SusConfress     VARCHAR(100)	,	\n"+                        
                "	StatusFreeze	VARCHAR(100)	,	\n"+ 
                "	AnswerPerson	VARCHAR(100)	,	\n"+ 
                "	FreezeOrganize     	VARCHAR(100)	,	\n"+
                "	FreezeDate     	VARCHAR(100)	,	\n"+                          
                "	SueLastEndDate	VARCHAR(100)	,	\n"+  
                "	CourtSuspect	VARCHAR(100)	,	\n"+
                "       GiveEvidence	VARCHAR(100)	,	\n"+    
                "       StatusArrestWarrant	VARCHAR(100)	,	\n"+                           
                "       NoArrestWarrant	VARCHAR(100)	,	\n"+    
                "       NameArrest	VARCHAR(100)	,	\n"+     
                "	RpAllegationsDate	DATE	,	\n"+
                "	RpAllegationsTime	VARCHAR(100)	,	\n"+
                "	StatusInjuryOrDie	VARCHAR(100)	,	\n"+ 
                 "	DateSendInjuredOrDie	VARCHAR(100)	,	\n"+
                "	TimeSendInjuredOrDie	VARCHAR(100)	,	\n"+                        
                "	NameSendInjuredOrDie	VARCHAR(100)	,	\n"+      
                "	CauseSendInjuredOrDie	VARCHAR(100)	,	\n"+
                "	WhereSendInjuredOrDie	VARCHAR(100)	,	\n"+   
                "	StatusWarrant	VARCHAR(100)	,	\n"+                        
                "	DateRelease	VARCHAR(100)	,	\n"+ 
                 "	OwnerBail	INTEGER,	\n"+                        
                "	SueFirst	VARCHAR(100)	,	\n"+
                "	SueFirstDate	DateTime	,	\n"+
                "	SueFirstStart	DateTime	,	\n"+
                "	SueFirstEnd	DateTime	,	\n"+
                "	SueFirstTotal	INTEGER	,	\n"+
                "	SueFirstRequest	VARCHAR(100)	,	\n"+
                "	SueFirstCause	VARCHAR(100)	,	\n"+
                "	SueSecond	VARCHAR(100),	\n"+
                "	SueSecDate	DateTime	,	\n"+
                "	SueSecStart	DateTime	,	\n"+
                "	SueSecEnd	DateTime	,	\n"+
                "	SueSecTotal	INTEGER	,	\n"+
                "	SueSecRequest	VARCHAR(100)	,	\n"+
                "	SueSecCause	VARCHAR(100)	,	\n"+
                "	SueThird	VARCHAR(100)	,	\n"+
                "	SueThirdDate	DateTime	,	\n"+
                "	SueThirdStart	DateTime	,	\n"+
                "	SueThirdEnd	DateTime	,	\n"+
                "	SueThirdTotal	INTEGER	,	\n"+
                "	SueThirdRequest	VARCHAR(100)	,	\n"+
                "	SueThirdCause	VARCHAR(100)	,	\n"+
                "	SueFourth	VARCHAR(100)	,	\n"+
                "	SueFourthDate	DateTime	,	\n"+
                "	SueFourthStart	DateTime	,	\n"+
                "	SueFourthEnd	DateTime	,	\n"+
                "	SueFourthtotal	INTEGER	,	\n"+
                "	SueFourthRequest	VARCHAR(100)	,	\n"+
                "	SueFourthCause	VARCHAR(100)	,	\n"+
                "	SueFifth	VARCHAR(100)	,	\n"+
                "	SueFifthDate	DateTime	,	\n"+
                "	SueFifthStart	DateTime	,	\n"+
                "	SueFifthEnd	DateTime	,	\n"+
                "	SueFifthTotal	INTEGER	,	\n"+
                "	SueFifthRequest	VARCHAR(100)	,	\n"+
                "	SueFifthCause	VARCHAR(100)	,	\n"+
                "	SueSixth	VARCHAR(100)	,	\n"+
                "	SueSixthDate	DateTime	,	\n"+
                "	SueSixthStart	DateTime	,	\n"+
                "	SueSixthEnd	DateTime	,	\n"+
                "	SueSixthTotal	INTEGER	,	\n"+
                "	SueSixthRequest	VARCHAR(100)	,	\n"+
                "	SueSixthCause	VARCHAR(100)	,	\n"+
                "	SueSeven	VARCHAR(100)	,	\n"+
                "	SueSevenDate	DateTime	,	\n"+
                "	SueSevenStart	DateTime	,	\n"+
                "	SueSevenEnd	DateTime	,	\n"+
                "	SueSevenTotal	INTEGER	,	\n"+
                "	SueSevenRequest	VARCHAR(100)	,	\n"+
                "	SueSevenCause	VARCHAR(100)	,	\n"+  
                "	OrderPerson	INTEGER	,	\n"+                        
                "	caseIdPerson	INTEGER	not null,	\n"+
                  "	BailIdPerson	INTEGER	,	\n"+
                    " CONSTRAINT fk_CrimeCase            \n"+
                                "FOREIGN KEY (caseIdPerson)            \n"+
                                "REFERENCES CrimeCase(CaseId)  \n"+
                                "ON DELETE SET NULL                     \n"+
                                  
                "	);	";	
      String sqlPersonData = "CREATE TABLE IF NOT EXISTS PersonData (\n"+
                "	NoPerson	INTEGER	Primary Key AUTOINCREMENT,	\n"+        	      
                "	PeopleRegistrationID	VARCHAR(13)	,	\n"+
                "	IssueDate	DATE	,	\n"+
                "	ExpiredDate	DATE	,	\n"+
                "	IssuedBy	VARCHAR(100)	,	\n"+
                "	PassportNumber	VARCHAR(100)	,	\n"+
                "	FullNamePerson	VARCHAR(100)	,	\n"+
                "	FullNamePersonEn	VARCHAR(100)	,	\n"+
                "	OtherName	VARCHAR(100)	,	\n"+
                "	OtherSurname	VARCHAR(100)	,	\n"+
                "	BirthDay	DATE	,	\n"+
                "	Gender	VARCHAR(100)	,	\n"+
                "	Age	VARCHAR(100)	,	\n"+
                "	Race	VARCHAR(100)	,	\n"+
                "	Nationality	VARCHAR(100)	,	\n"+
                "	Religion	VARCHAR(100)	,	\n"+
                "	Occupation	VARCHAR(100)	,	\n"+
               "	OccupationPosition	VARCHAR(100)	,	\n"+
               "	StatusSueAndPutInJail	VARCHAR(100)	,	\n"+              
                "	Height	VARCHAR(100)	,	\n"+
                "	Weight	VARCHAR(100)	,	\n"+
                "	BloodGroup	VARCHAR(100)	,	\n"+
                "	HouseNumber	VARCHAR(100)	,	\n"+
                "	Moo	VARCHAR(100)	,	\n"+
                "	Tambon	VARCHAR(100)	,	\n"+
                "	Amphur	VARCHAR(100)	,	\n"+
                "	Province	VARCHAR(100)	,	\n"+
                "	ZipCode	VARCHAR(100)	,	\n"+
                "	PhonePerson	VARCHAR(100)	,	\n"+
                "	HeadmanName	VARCHAR(100)	,	\n"+
                "	SubHeadmanName	VARCHAR(100)	,	\n"+
                "	FatherFullName	VARCHAR(100)	,	\n"+
                "	MotherFullName	VARCHAR(100)	,	\n"+
                "	TambonBirthday	VARCHAR(100)	,	\n"+
                "	AmphurBirthday	VARCHAR(100)	,	\n"+
                "	ProvinceBirthday	VARCHAR(100)	,	\n"+
                "	PlaceBorn	VARCHAR(100)	,	\n"+               
                "	Country         VARCHAR(100)	,	\n"+          
                "	FatherAge	VARCHAR(100)	,	\n"+
                "	FatherCareer	VARCHAR(100)	,	\n"+
                "	FatherIdCard	VARCHAR(100)	,	\n"+
                "	FatherAddress	VARCHAR(100)	,	\n"+
                "	FatherPhone	VARCHAR(100)	,	\n"+
                "	MotherAge	VARCHAR(100)	,	\n"+
                "	MotherCareer	VARCHAR(100)	,	\n"+
                "	MotherIdCard	VARCHAR(100)	,	\n"+
                "	MotherAddress	VARCHAR(100)	,	\n"+
                "	MotherPhone	VARCHAR(100)	,	\n"+
                "	ParentName	VARCHAR(100)	,	\n"+                        
                "	ParentAge	VARCHAR(100)	,	\n"+
                "	ParentCareer	VARCHAR(100)	,	\n"+
                "	ParentIdCard	VARCHAR(100)	,	\n"+
                "	ParentAddress	VARCHAR(100)	,	\n"+
                "	ParentPhone	VARCHAR(100)	,	\n"+
                "	Office	VARCHAR(100)	,	\n"+
                "	SpouseFullName	VARCHAR(100)	,	\n"+
                "	Education	VARCHAR(100)	,	\n"+
                "	FriendAddress	VARCHAR(100)	,	\n"+
                "	CarUse	VARCHAR(100)	,	\n"+              
                "	FavouritePlace	VARCHAR(100)	,	\n"+
                "	Identification	VARCHAR(100)	,	\n"+
                "	InterrogateDate	VARCHAR(100)	,	\n"+
                "	CurrentAddress	VARCHAR(100)	,	\n"+
                "	RestoreDate	VARCHAR(100)	,	\n"+ 
                "	Road     	VARCHAR(100)	,	\n"+
                "	Soi     	VARCHAR(100)	,	\n"+
                "	NotePersonData  VARCHAR(100)	,	\n"+              
                "      WarrantList      VARCHAR(100)		\n"+
                "	);	";	
                       
                  String sqlCrimeCase ="CREATE TABLE IF NOT EXISTS CrimeCase (\n"+
                       "	CaseId	INTEGER	Primary Key,	\n"+
                        "	CaseType	VARCHAR(100)	,	\n"+
                        "	SendIDocDate	DATE	,	\n"+
                        "	crimecaseno	VARCHAR(100)	not null,	\n"+
                        "	crimecaseyears	VARCHAR(100)	,	\n"+
                        "	crimecasenoyear	VARCHAR(100)	,	\n"+
                        "	OccuredDate	DATE	,	\n"+
                          "	OccuredDateEnd	DATE	,	\n"+
                        "	CaseAcceptDate	DATE	,	\n"+
                        "	CaseRequestDate	DATE	,	\n"+
                        "	OccuredTime	VARCHAR(100)	,	\n"+
                        "	OccuredTimeEnd	VARCHAR(100)	,	\n"+
                        "	CaseAccepTime	VARCHAR(100)	,	\n"+
                        "	CaseRequestTime	VARCHAR(100)	,	\n"+
                        "	ChargeCodeCase	INTEGER	,	\n"+
                        "	CrimeLocation	VARCHAR(100)	,	\n"+
                        "	CrimeLocationMoo	VARCHAR(100)	,	\n"+
                        "	CrimeLocationSoi	VARCHAR(100)	,	\n"+
                        "	CrimeLocationRoad	VARCHAR(100)	,	\n"+
                        "	CrimeLocationDistrict	VARCHAR(100)	,	\n"+
                        "	CrimeLocationAmphur	VARCHAR(100)	,	\n"+
                        "	CrimeLocationProvince	VARCHAR(100)	,	\n"+
                        "	DailyNumber	VARCHAR(100)	,	\n"+
                        "	DocOrder	VARCHAR(100)	,	\n"+
                        "	DocSlash	VARCHAR(100)	,	\n"+
                        "	AmountCopyInvestigate	VARCHAR(100)	,	\n"+
                        "	RecordDatePolice	VARCHAR(100)	,	\n"+
                        "	RecordWorkPolice	VARCHAR(100)	,	\n"+
                        "	CheckDateTime	VARCHAR(100)	,	\n"+
                        "	CheckDateTimeTo	VARCHAR(100)	,	\n"+
                        "	LawName	VARCHAR(100)	,	\n"+
                        "	ActionCodeCase	INTEGER	,	\n"+
                        "	TypeCourt	VARCHAR(100)	,	\n"+
                        "	BlackCaseNo	VARCHAR(100)	,	\n"+
                        "	BlackCaseYear	VARCHAR(100)	,	\n"+
                        "	RedCaseNo	VARCHAR(100)	,	\n"+
                        "	RedCaseYear	VARCHAR(100)	,	\n"+
                        "	Investigator_Result	VARCHAR(100)	,	\n"+
                        "	Invest_SendtoDepartment	VARCHAR(100)	,	\n"+
                        "	Investigator_Number	VARCHAR(100)	,	\n"+
                        "	Invest_SendCaseDate	VARCHAR(100)	,	\n"+
                        "	Prosecutor_Result	VARCHAR(100)	,	\n"+
                        "	CourtResult	VARCHAR(100)	,	\n"+
                        "	CapitalCrimeCaseNumber	VARCHAR(100),		\n"+
                          "	AccureandOther	VARCHAR(100),		\n"+
                        "	SuspectandOther	VARCHAR(100),	\n"+
                        "	WitnessandOther	VARCHAR(100),   \n"+
                          "	PoliceNameCase	VARCHAR(100)	,	\n"+
                        "	AssetCode	VARCHAR(100)	,	\n"+
                        "	AssetList	VARCHAR(100)	,	\n"+
                          "	CauseDead	VARCHAR(100)	,	\n"+
                          "	RecordInvestCase	VARCHAR(100)	,	\n"+
                          "	StatusKnowSuspect	VARCHAR(100)	,	\n"+ 
                        "	TotalAcc     	VARCHAR(100)	,	\n"+  
                         "	TotalSus	VARCHAR(100)	,	\n"+  
                          "	TotalWitness	VARCHAR(100)	,	\n"+                           
                         "	CircumstancesOfDeath	VARCHAR(100)		\n"+
                         "	);";
          String sqlAsset ="CREATE TABLE IF NOT EXISTS Asset (\n"+                 
            "	NoAsset	INTEGER	Primary Key AUTOINCREMENT,	\n"+        
                "	EvidenceRecordNumber	VARCHAR(100),	\n"+
                "	OrderAsset	INTEGER	,	\n"+
                "	Name	VARCHAR(100)	,	\n"+
                "	Amount	VARCHAR(100)	,	\n"+
                "	Value	VARCHAR(100)	,	\n"+
                "	OccupantName	VARCHAR(100)	,	\n"+
                "	DateSequester	VARCHAR(100)	,	\n"+
                "	Remark  	VARCHAR(100)	,	\n"+
                "	PlaceFoundExhibit	VARCHAR(100)	,	\n"+
                "	DefectMark	VARCHAR(100)	,	\n"+
                "	PointFoundCheck	VARCHAR(100)	,	\n"+
                "	StatusAsset	VARCHAR(100)	,	\n"+
                "	SerialNO	VARCHAR(100)	,	\n"+
                "	Brand	VARCHAR(100)	,	\n"+
                "	Color	VARCHAR(100)	,	\n"+  
                "	EngineNumber	VARCHAR(100)	,	\n"+
                "	ChasisNumber	VARCHAR(100)	,	\n"+  
                "	SumOrderAsset 	INTEGER   	,	\n"+
                "	SumValue	VARCHAR(100)	,	\n"+
                "	caseIdAsset	INTEGER	not null	\n"+          
                "	);";
          
          
          String sqlPolice ="CREATE TABLE IF NOT EXISTS Police (\n"+
                        "	IdPolice	INTEGER	 Primary Key,	\n"+
	                "	IdCardPolice	VARCHAR(13)	,	\n"+
                          "	RankPoliceFull	VARCHAR(100)	,	\n"+
                        "	RankPolice	VARCHAR(100)	,	\n"+
                        "	FirstName	VARCHAR(100)	,	\n"+
                        "	LastName	VARCHAR(100)	,	\n"+
                        "	Birthday	VARCHAR(100)	,	\n"+
                        "	Age             VARCHAR(100)	,	\n"+
                        "	Tel             VARCHAR(100)	,	\n"+
                        "	Position	VARCHAR(100)		\n"+
                         "	);";
	  String sqlPoliceStat ="CREATE TABLE IF NOT EXISTS PoliceStation (\n"+
                       "	PoliceStartionId	INTEGER	Primary Key ,	\n"+ 
                        "	PoliceStartionCode	VARCHAR(100)   ,	\n"+
                        "	PoliceStaionName	VARCHAR(100)	,	\n"+
                        "	PoliceStaionShort	VARCHAR(100)	,	\n"+
                        "	StationAddress	VARCHAR(100)	,	\n"+
                        "	StationAmphur	VARCHAR(100)	,	\n"+
                        "	StationProvince	VARCHAR(100)	,	\n"+
                          "	StationTambon	VARCHAR(100)	,	\n"+
                          "	StationMoo	VARCHAR(100)	,	\n"+
                          "	PostCode	VARCHAR(100)	,	\n"+
                        "	KK	VARCHAR(100)	,	\n"+
                        "	BK	VARCHAR(100)	,	\n"+
                        "	BH	VARCHAR(100)	,	\n"+
                        "	TelStation	VARCHAR(100)	,	\n"+
                        "	PhonePolice	VARCHAR(100)	,	\n"+
                        "	Fax	VARCHAR(100)	,	\n"+
                        "	HeadRankFull	VARCHAR(100)	,	\n"+
                        "	HeadRankShort	VARCHAR(100)	,	\n"+
                        "	HeadName	VARCHAR(100)	,	\n"+
                        "	HeadPosition	VARCHAR(100)	,	\n"+
                         "	HeadWorkRankFull	VARCHAR(100)	,	\n"+
                        "	HeadWorkRankShort	VARCHAR(100)	,	\n"+
                        "	HeadWorkName	VARCHAR(100)	,	\n"+
                        "	HeadWorkPosition	VARCHAR(100)	,	\n"+     
                        "	CriminalCourt	VARCHAR(100)	,	\n"+
                        "	JuvenileCourt	VARCHAR(100)	,	\n"+
                        "	DistrictCourt	VARCHAR(100)	,	\n"+
                        "	MilitaryCourt	VARCHAR(100)	,	\n"+
                        "	AssetCourt	VARCHAR(100)	,	\n"+
                        "	LocationOfDrug 	VARCHAR(100)	,	\n"+
                        "	CheckGun	VARCHAR(100)	,	\n"+
                        "	CheckDrug	VARCHAR(100)	,	\n"+
                        "	CheckOtherExhibit	VARCHAR(100)	,	\n"+
                        "	CauseSerious	VARCHAR(100)	,	\n"+
                        "	ProvincProsecutor	VARCHAR(100)	,	\n"+
                        "	ProvincProsecutorCh	VARCHAR(100)	,	\n"+
                        "	THNumBook	VARCHAR(100)	,	\n"+
                        "	ProtectChild	VARCHAR(100)		\n"+
                         "	);";       
           String sqlChargeCase ="CREATE TABLE IF NOT EXISTS ChargeCase (\n"+
	            "	ChargeCodeid	INTEGER	Primary Key AUTOINCREMENT,	\n"+
                    "	ChargeCodeCase	INTEGER	,	\n"+
                    "	ChargeNameCase	VARCHAR(100)	,	\n"+
                    "	LawCase	VARCHAR(100)	,	\n"+
                    "	RateOfPenaltyCase	VARCHAR(100)	,	\n"+
                    "	NoteCase	VARCHAR(100)	,	\n"+
                   "	ChargeCaseId	INTEGER 	\n"+
                         "	);";      
           String sqlCharge ="CREATE TABLE IF NOT EXISTS Charge (\n"+
                   "	ChargeCode	INTEGER	Primary Key,	\n"+
	           
                    "	ChargeName	VARCHAR(100)	,	\n"+
                    "	Law	VARCHAR(100)	,	\n"+
                    "	RateOfPenalty	VARCHAR(100)	,	\n"+
                    "	Note	VARCHAR(100)		\n"+
                         "	);";    
           
            String sqlAction ="CREATE TABLE IF NOT EXISTS ActionsCase (\n"+
                    "	ActionCode	INTEGER	Primary Key,	\n"+
                    "	ActionCrimes	VARCHAR(100)	,	\n"+
                    "	ActionDetail	VARCHAR(100)	,	\n"+
                        "	AnswerSuspect	VARCHAR(100)	,	\n"+
                        "	AnswerAccuser   	VARCHAR(100)	,	\n"+                    
                    "	ActionNote	VARCHAR(100) 		\n"+
                    "	);";    
                String sqlActionCase ="CREATE TABLE IF NOT EXISTS ActionsCaseData (\n"+
                    "	ActionCodeCaseId	INTEGER	Primary Key AUTOINCREMENT,	\n"+                        
                    "	ActionCodeCase	INTEGER	 ,	\n"+
                    "	ActionCrimesCase	VARCHAR(100)	,	\n"+
                    "	ActionDetailCase	VARCHAR(100)	,	\n"+
                    "	AnswerSuspectCase	VARCHAR(100)	,	\n"+
                     "	AnswerAccuserCase   	VARCHAR(100)	,	\n"+                    
                    "	ActionNoteCase	VARCHAR(100) ,		\n"+
                      "	ActionCaseId	INTEGER 	\n"+                        
                    "	);";    
                
            String sqlRecord ="CREATE TABLE IF NOT EXISTS RecordInquiry (\n"+
                    "	IdRecord	INTEGER	Primary Key AUTOINCREMENT,	\n"+
                    "	DateRecord	VARCHAR(100)	,	\n"+ 
                    "	TimeRecord	VARCHAR(100)	,	\n"+
                    "	NameInguiry	VARCHAR(100)	,	\n"+
                    "	DetailRecord	VARCHAR(100)	,	\n"+
                    "	DailyNoRecord	VARCHAR(100)	,	\n"+
                    "	CaseIdRecord	INTEGER	not null	\n"+    
                    "	);";   
             String sqlInvest ="CREATE TABLE IF NOT EXISTS InvestInformation (\n"+
	             "	InvestId	INTEGER	Primary Key Not Null,	\n"+
                     "	InvestCardID	VARCHAR(100)	,	\n"+
                      "	InvestRankFull	VARCHAR(100)	,	\n"+    
                    "	InvestRank	VARCHAR(100)	,	\n"+                     
                    "	InvestName	VARCHAR(100)	,	\n"+
                    "	InvestPosition	VARCHAR(100)	,	\n"+
                    "	InvestBirthDay	VARCHAR(100)	,	\n"+
                    "	InvestAge	VARCHAR(100)	,	\n"+
                    "	InvestTel	VARCHAR(100)		\n"+
                    "	);";
             
         
               
            String sqlBailAsset ="CREATE TABLE IF NOT EXISTS BailAsset (\n"+
                            "	BailAssetId	INTEGER	Primary Key AUTOINCREMENT,	\n"+
                            "	BailAssetOrder	INTEGER	,	\n"+
                            "	BailAssetDetail	VARCHAR(100)	,	\n"+
                            "	BailAmount	VARCHAR(100)	,	\n"+
                            "	BailAssetBath	VARCHAR(100)	,	\n"+
                            "	BailAssetTotal	VARCHAR(100)	,	\n"+
                            "	BailAssetRemark	VARCHAR(100)	,	\n"+
                            "	BailCaseId	INTEGER	,	\n"+
                            "	BailPersonId	INTEGER		\n"+
                    "	);";
       
                String sqlDeliverySuspect ="CREATE TABLE IF NOT EXISTS DeliverySuspect (\n"+
                                "	DeliId	INTEGER	Primary Key AUTOINCREMENT,	\n"+
                                "	DeliOrder	INTEGER	,	\n"+
                                "	DeliDate	VARCHAR(100)	,	\n"+
                                "	DeliTimes	VARCHAR(100)	,	\n"+
                                "	DeliPlace	VARCHAR(100)	,	\n"+
                                "	DeliPersonId	INTEGER,	\n"+
                                " CONSTRAINT fk_Person            \n"+
                                "FOREIGN KEY (DeliPersonId)            \n"+
                                "REFERENCES Person(NoPerson)  \n"+
                                "ON DELETE SET NULL                     \n"+
                                "	);"; 
                
      
         String sqlProvince ="CREATE TABLE IF NOT EXISTS Province (\n"+               
                "	NAMEPROVINCE	VARCHAR(100),	\n"+
                "	PROVINCEID	VARCHAR(100)	Primary Key,	\n"+
                "	LOC_CODE	VARCHAR(100)	,	\n"+
                "	DOPA_CODE	VARCHAR(100)		\n"+        
                                "	);"; 
          String sqlAmphur ="CREATE TABLE IF NOT EXISTS Amphur (\n"+
                 "	APID	INTEGER	Primary Key,	\n"+  
                "	NAMEAMPHUR	VARCHAR(100),	\n"+
                "	AMPHURID	VARCHAR(100)	,	\n"+
                "	AMPPROVINCEID	VARCHAR(100)	,	\n"+
                "	LOC_CODE	VARCHAR(100)	,	\n"+
                "	DOPA_CODE	VARCHAR(100)		\n"+        
                                "	);"; 
             String sqlTambon ="CREATE TABLE IF NOT EXISTS Tambon (\n"+          
                "	TBID	INTEGER Primary Key,	\n"+                    
                "	NAMETAMBON	VARCHAR(100),	\n"+
                "	TBMPHURID	VARCHAR(100)	,	\n"+
                "	TBPROVINCEID	VARCHAR(100)	,	\n"+
                "	TAMBONID	VARCHAR(100)	,	\n"+
                "	ZIPCODE	VARCHAR(100)	,	\n"+
                "	LOC_CODE	VARCHAR(100)	,	\n"+
                "	DOPA_CODE	VARCHAR(100)		\n"+        
                                "	);"; 

 
	        try ( 
                        Statement stmt = cc.createStatement()) {
	            // create a new table
                   
	              stmt.execute(sqlPerson);
                      stmt.execute(sqlCrimeCase); 
                      stmt.execute(sqlAsset); 
                      stmt.execute(sqlPolice); 
                      stmt.execute(sqlPoliceStat); 
                      stmt.execute(sqlCharge); 
                      stmt.execute(sqlAction); 
                      stmt.execute(sqlRecord); 
                      stmt.execute(sqlInvest);
                       stmt.execute(sqlBailAsset);
                      stmt.execute(sqlDeliverySuspect);
                       stmt.execute(sqlChargeCase);
                       stmt.execute(sqlProvince);
                       stmt.execute(sqlAmphur);
                       stmt.execute(sqlTambon);  
                       stmt.execute(sqlPersonData);  
                       stmt.execute(sqlActionCase);   
                        stmt.execute(sqlAnswer);  
                       stmt.execute(sqlLogin);
                       stmt.execute(sqlHolidays);  
                       stmt.execute(sqlParameter);  
                       stmt.execute(sqlDataCharge);  
                       stmt.execute(sqlDataForm);  
                       stmt.close();
                    System.out.println("Create Table Complete");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
                
                


                
	    }
	 
          public static void InsertBaseData() {
//                InsertBaseData.Insert();
	        // SQLite connection string
	       Connection cc= ConnectDatabase.connect();
//             String url = "jdbc:sqlite:D://db/SR2.db";
                Connection connect = null;
	       Statement s=null;
               Statement s2=null;
	        // SQL statement for creating a new table
	     

	        try {   
                    connect=ConnectDatabase.connect();
                    s=connect.createStatement();
                    s2=connect.createStatement();
                    String [] insertAction = {
                        "	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	1	,	'ใช้กระแสไฟฟ้าทำการประมงในที่จับสัตว์น้ำ'	,	'เจ้าหน้าที่ชุดจับกุม ออกตรวจที่เกิดเหตุ พบผู้ต้องหากำลังจับปลาในที่เกิดเหตุ โดยใช้เครื่องมือไฟฟ้าในการจับปลาอยู่ในที่เกิดเหตุอันเป็นที่จับสัตว์น้ำประเภทสาธารณประโยชน์ จึงได้เข้าไปตรวจสอบ พบว่าผู้ต้องหาไม่ได้รับอนุญาตให้ทำการประมงหรือจับปลาโดยใช้ประแสไฟฟ้า จึงยึดเครื่องมือดังกล่าวไว้เป็นของกลาง จับกุมผู้ต้องหาพร้อมนำของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหากำลังจับปลาอยู่ในที่เกิดเหตุ โดยใช้เครื่องมือทำกระแสไฟฟ้า ซึ่งภายหลังเจ้าหน้าที่ชุดจับกุมตรวจยึดไว้เป็นของกลางใน ได้มีเจ้าหน้าที่ดังกล่าว (ทราบชื่อภายหลังปรากฏตามบันทึกการจับกุมในคดีนี้) เข้ามาแสดงตนเป็นเจ้าหน้าที่ขอตรวจสอบ พบว่าผู้ต้องหาไม่ได้รับอนุญาตให้ทำการประมงหรือจับปลาโดยใช้ประแสไฟฟ้า เจ้าหน้าที่ชุดจับกุมจึงได้แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหารับทราบข้อกล่าวหาแล้ว ให้การรับสารภาพตลอดข้อกล่าวหา เจ้าหน้าที่ชุดจับกุมได้นำผู้ต้องหาและของกลาง ส่งพนักงานสอบสวนดำเนินคดี'	,	'ผู้กล่าวหากับพวก ปรากฏรายชื่อตามบันทึกการจับกุมในคดีนี้ ได้ร่วมกันออกตรวจที่เกิดเหตุเพื่อป้องกันปราบปรามและติดตามจับกุมผู้ที่กระทำความผิดตามกฎหมายว่าด้วยการประมง พบผู้ต้องหากำลังจับปลาในที่เกิดเหตุ อันเป็นที่จับสัตว์น้ำประเภทสาธารณประโยชน์ โดยใช้เครื่องมือไฟฟ้าในการจับปลาซึ่งภายหลังได้ตรวจยึดไว้เป็นของกลาง รายละเอียดปรากฏตามบัญชีของกลางในคดีนี้ จึงได้เข้าไปตรวจสอบ พบว่าผู้ต้องหาไม่ได้รับอนุญาตให้ทำการประมงหรือจับปลาโดยใช้ประแสไฟฟ้า ผู้กล่าวหากับพวกจึงยึดเครื่องมือดังกล่าวไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหารับทราบข้อกล่าวหาแล้ว ให้การรับสารภาพตลอดข้อกล่าวหา จึงจับกุมผู้ต้องหา พร้อมนำของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	2	,	'ลักลอบเล่นการพนันทายผลฟุตบอล'	,	'ตามวันเวลาที่เกิดเหตุ เจ้าหน้าที่ชุดจับกุมได้ตรวจค้นพบโพยฉลากทายผลฟุตบอล อยู่ในความครอบครองของผู้ต้องหา ซึ่งเป็นโพยทายผลฟุตบอลที่มีการแข่งขันในต่างประเทศ ที่ผู้ต้องหาได้มาจากเจ้ามือ ออกให้กับผู้ต้องหา ในการเล่นการพนันทายผลการแพ้หรือชนะ ในการเล่นฟุตบอล เพื่อพนันเอาทรัพย์สินกันโดยไม่ได้รับอนุญาต โดย จึงได้ยึดไว้เป็นของกลาง จับกุมผู้ต้องหาและนำของกลางดังกล่าวส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ผู้ต้องหาได้พร้อมกับพวกซึ่งเป็นเจ้ามือรับพนันทายผลการแข่งขันฟุตบอลของต่างประเทศ พนันเอาทรัพย์สินกันโดยไม่ได้รับอนุญาต โดยผู้ต้องหาเป็นผู้ทาย โดยเอาผลการแพ้ชนะของคู่ที่แข่งขันที่ปรากฏในโพย ซึ่งภายหลังเจ้าหน้าที่ได้ยึดไว้เป็นของกลางในคดีนี้ เป็นหลักการแพ้ชนะในการพนัน ต่อมาเจ้าหน้าที่ชุดจับกุมได้ตรวจพบโพยดังกล่าวในความครอบครองของผู้ต้องหา ผู้ต้องหาจึงได้จับกุมตัวพร้อมโพยของกลาง และของกลางในคดีนี้ ที่ผู้ต้องหากับพวกได้ใช้หรือได้มาจากการเล่นการพนัน นำส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ เจ้าหน้าที่ชุดจับกุมได้ออกตรวจพื้นที่ที่รับผิดชอบ เมื่อมาถึงที่เกิดเหตุพบผู้ต้องหามีท่าทางพิรุธ จึงได้แสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้น ซึ่งผู้ต้องหาได้ยินยอมให้ตรวจค้นแต่โดยดี โดยก่อนลงมือตรวจค้นได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูก่อนแล้ว ผลการตรวจค้นพบโพยเล่นการพนันทายผลฟุตบอล อยู่ในความครอบครองของผู้ต้องหา จึงได้สอบถามผู้ต้องหาถึงโพยดังกล่าว ซึ่งผู้ต้องหารับว่าเป็นโพยทายผลฟุตบอลของตน ที่เจ้ามือได้ออกให้กับผู้เล่นหรือผู้ต้องหา ในการการพนันทายผลการเล่น พนันเอาทรัพย์สินกันโดยไม่ได้รับอนุญาต จึงได้ยึดไว้เป็นของกลาง จับกุมผู้ต้องหาและนำของกลางดังกล่าวส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	3	,	'ใช้รถในการขนส่งไม่ได้จดทะเบียน และเสียภาษีประจำปี ยึดรถเป็นของกลาง'	,	'ผู้กล่าวหากับพวกกับพวกปฏิบัติหน้าที่ตั้งจุดตรวจในที่เกิดเหตุ พบผู้ต้องหาขับขี่รถประเภทขนส่ง ผ่านที่เกิดเหตุได้เรียกให้หยุด ขอตรวจสอบ พบผู้ต้องหาเป็นผู้ขับขี่รถขนส่งโดยไม่ได้รับอนุญาต และรถคันดังกล่าวไม่เสียภาษีประจำปี จึงจับกุมส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ผู้ต้องหาได้ขับขี่รถประเภทขนส่งมาตามถนนที่เกิดเหตุ เมื่อมาถึงที่เกิดเหตุพบผู้กล่าวหากับพวกกับพวกปฏิบัติหน้าที่ตั้งจุดตรวจในที่เกิดเหตุ ได้เรียกให้หยุด ขอตรวจสอบ พบว่าผู้ต้องหาได้ขับขี่รถประเภทขนส่ง โดยที่ผู้ต้องหาไม่ได้รับอนุญาตให้ขับขี่ และรถคันดังกล่าวไม่เสียภาษีประจำปี จึงจับกุมส่งพนักงานสอบสวนดำเนินคดี'	,	'ผู้กล่าวหากับพวกกับพวกปฏิบัติหน้าที่ตั้งจุดตรวจในที่เกิดเหตุ พบผู้ต้องหาขับขี่รถประเภทขนส่ง ผ่านที่เกิดเหตุได้เรียกให้หยุด ขอตรวจสอบ พบผู้ต้องหาได้ขับขี่รถประเภทขนส่ง และโดยที่ผู้ต้องหาไม่ได้รับอนุญาตให้ขับขี่ และรถคันดังกล่าวไม่เสียภาษีประจำปี จึงจับกุมส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	4	,	'ใช้ยานพาหนะที่บรรทุกน้ำหนักเกินอัตราที่กฎหมายกำหนด เดินบนทางหลวง'	,	'ผู้กล่าวหากับพวกกับพวกปฏิบัติหน้าที่ตั้งจุดตรวจบนถนนหลวงที่เกิดเหตุ ตรวจพบผู้ต้องหาขับขี่รถบรรทุกน้ำหนักเกินอัตราที่กฎหมายกำหนด จึงจับกุมส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหาขับขี่รถบรรทุก บรรทุกสิ่งของผ่านมาในที่เกิดเหตุ พบผู้กล่าวหากับพวก ทราบชื่อภายหลังปรากฏตามบันทึกการจับกุมในคดีนี้ ได้เรียกให้หยุดขอตรวจสอบน้ำหนักรถบรรทุกที่ผู้ต้องหาขับขี่มา ผลการตรวจสอบปรากฏว่า นำหนักรถบรรทุกมีน้ำหนักเกินอัตราที่กฎหมายกำหนด เจ้าหน้าที่จึงได้ยึดรถดังกล่าวไว้เป็นของกลาง จึงจับกุมผู้ต้องหาพร้อมกับนำของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ผู้กล่าวหากับพวกกับพวกปฏิบัติหน้าที่ตั้งจุดตรวจในที่เกิดเหตุ พบผู้ต้องหาขับขี่รถบรรทุก บรรทุกสิ่งของผ่านมาตามถนนที่เกิดเหตุ ซึ่งน่าจะมีน้ำหนักเกินที่กฎหมายกำหนด จึงได้นำไปตรวจชั่งน้ำหนัก ปรากฏว่า นำหนักรถบรรทุกมีน้ำหนักเกินอัตราที่กฎหมายกำหนด จึงได้ยึดรถดังกล่าวไว้เป็นของกลาง จึงจับกุมผู้ต้องหาพร้อมกับนำของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	5	,	'ปฏิบัติหน้าที่เป็นผู้ประจำรถ ( ผู้ขับรถ ) โดยไม่ได้รับอนุญาตจากนายทะเบียน'	,	'ผู้กล่าวหากับพวกกับพวกปฏิบัติหน้าที่ตั้งจุดตรวจในที่เกิดเหตุ พบผู้ต้องหาขับขี่รถประเภทขนส่ง ผ่านที่เกิดเหตุได้เรียกให้หยุด ขอตรวจสอบ พบผู้ต้องหาปฏิบัติหน้าที่เป็นผู้ประจำรถ ( ผู้ขับรถ ) โดยไม่ได้รับอนุญาตจากนายทะเบียน จึงจับกุมส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ผู้ต้องหาได้ขับขี่รถประเภทขนส่งมาตามถนนที่เกิดเหตุ เมื่อมาถึงที่เกิดเหตุพบผู้กล่าวหากับพวกกับพวกปฏิบัติหน้าที่ตั้งจุดตรวจในที่เกิดเหตุ ได้เรียกให้หยุด ขอตรวจสอบ พบว่าผู้ต้องหาได้ขับขี่รถประเภทขนส่ง โดยที่ผู้ต้องหาไม่ได้รับอนุญาตให้ขับขี่ จึงจับกุมส่งพนักงานสอบสวนดำเนินคดี'	,	'ผู้กล่าวหากับพวกกับพวกปฏิบัติหน้าที่ตั้งจุดตรวจในที่เกิดเหตุ พบผู้ต้องหาขับขี่รถประเภทขนส่ง ผ่านที่เกิดเหตุได้เรียกให้หยุด ขอตรวจสอบ พบผู้ต้องหาได้ขับขี่รถประเภทขนส่ง โดยที่ผู้ต้องหาไม่ได้รับอนุญาตให้ขับขี่ จึงจับกุมส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	6	,	'ออกตรวจที่เกิดเหตุ พบผู้ต้องหามีของกลางผิดกฎหมายในครอบครอง'	,	'เจ้าหน้าที่ชุดจับกุม ออกตรวจที่เกิดเหตุ พบผู้ต้องหามีของกลางผิดกฎหมายในครอบครอง จึงยึดเป็นของกลาง จับกุมผู้ต้องหาพร้อมนำของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหากำลังอยู่ในที่เกิดเหตุ ได้มีเจ้าหน้าที่ทราบชื่อภายหลังปรากฏตามบันทึกการจับกุมในคดีนี้ เข้ามาแสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้น ซึ่งผู้ต้องหายินยอมให้ตรวจค้นแต่โดยดี และก่อนตรวจค้นได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูจนเป็นที่พอใจแล้ว ผลการตรวจค้นเจ้าหน้าที่ฯพบของกลางผิดกฎหมายอยู่ในความครอบครองของผู้ต้องหา เจ้าหน้าที่ชุดจับกุมจึงได้ยึดไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหารับทราบข้อกล่าวหาแล้ว ให้การรับสารภาพตลอดข้อกล่าวหา จึงถูกจับกุม เจ้าหน้าที่ชุดจับกุมได้นำผู้ต้องหาและของกลาง ส่งพนักงานสอบสวนดำเนินคดี'	,	'ผู้กล่าวหากับพวก ปรากฏรายชื่อตามบันทึกการจับกุมในคดีนี้ ได้ร่วมกันออกตรวจที่เกิดเหตุ พบผู้ต้องหามีของกลางผิดกฎหมายในครอบครอง จึงได้สอบถามผู้ต้องหาถึงของกลางดังกล่าว ผู้ต้องหารับว่าของกลางเป็นของผู้ต้องหามีไว้ในครอบครองโดยผิดกฎหมาย ผู้กล่าวหากับพวกจึงได้ยึดไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหารับทราบข้อกล่าวหาแล้ว ให้การรับสารภาพตลอดข้อกล่าวหา จึงจับกุมผู้ต้องหา พร้อมนำของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	7	,	'นำหมายค้นค้นบ้าน พบกระสุนปืน'	,	'เจ้าหน้าที่ชุดจับกุม นำหมายค้นไปตรวจค้นบ้านพักของผู้ต้องหา ซึ่งเป็นที่เกิดเหตุในคดีนี้ พบผู้ต้องหามีเครื่องกระสุนปืนไว้ในครอบครอง โดยไม่ได้รับอนุญาต จึงยึดเป็นของกลาง จับกุมผู้ต้องหาพร้อมนำของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหาอยู่ที่บ้านพักของผู้ต้องหา ได้มีเจ้าหน้าที่ชุดจับกุม ทราบชื่อภายหลังปรากฏตามบันทึกการจับกุมในคดีนี้ ได้นำหมายค้นของศาล มาขอตรวจค้นบ้านพักของผู้ต้องหา ซึ่งผู้ต้องหาได้แสดงตนเป็นเจ้าของบ้าน และเป็นผู้นำทำการตรวจค้น โดยก่อนที่จะลงมือตรวจค้น เจ้าหน้าที่ผู้ตรวจค้น ได้แสดงความบริสุทธิ์ใจจนเป็นที่พอใจแก่ผู้ต้องหาแล้ว ผลการตรวจค้นผู้กล่าวหากับพวกพบกระสุนปืนของกลาง ปรากฏรายละเอียดตามบัญชีของกลางในคดีนี้ อยู่ในความครอบครองของผู้ต้องหา ซึ่งผู้ต้องหาไม่ได้รับอนุญาตให้มีไว้ในครอบครอง เจ้าหน้าที่ฯจึงได้ยึดไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพ จึงได้ถูกจับกุมนำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหากับพวกได้นำหมายค้นของศาล ไปทำการตรวจค้นบ้านพักของผู้ต้องหา ซึ่งเป็นที่เกิดเหตุในคดีนี้ เนื่องจากสืบทราบว่ามีสิ่งของผิดกฎหมายซุกซ่อนอยู่ พบผู้ต้องหาอยู่ภายในบ้านและแสดงตนเป็นเจ้าของบ้าน จึงได้แสดงหมายค้นให้ผู้ต้องหาดู และขอทำการตรวจค้น ซึ่งผู้ต้องหายินยอมให้ตรวจค้น และเป็นผู้นำทำการตรวจค้น โดยก่อนที่จะลงมือตรวจค้น ได้แสดงความบริสุทธิ์ใจจนเป็นที่พอใจแก่ผู้ต้องหาแล้ว ผลการตรวจค้นผู้กล่าวหากับพวกพบกระสุนปืนของกลาง ซึ่งได้ยึดไว้เป็นของกลางปรากฏตามบัญชีของกลางในคดีนี้ อยู่ในความครอบครองของผู้ต้องหา ซึ่งผู้ต้องหารับว่าไม่ได้รับอนุญาตให้มีไว้ในครอบครอง จึงได้ยึดไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพ จึงได้จับกุมนำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	8	,	'ขุดลอกแม่แม่น้ำลำคลอง'	,	'เจ้าหน้าที่ชุดจับกุม ออกตรวจที่เกิดเหตุ พบผู้ต้องหากำลังใช้รถแบ็คโค ขุดลอกลำน้ำที่เกิดเหตุ จึงได้ตรวจสอบ พบว่าผู้ต้องหาไม่ได้รับอนุญาตพนักงานเจ้าหน้าที่ จึงได้ยึดรถไว้เป็นของกลางและจับกุมผู้ต้องหา ส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุในขณะที่ผู้ต้องหากำลังใช้รถแบ็คโค ซึ่งภายหลังได้ยึดไว้เป็นของกลางปรากฏตามบัญชีของกลางในคดีนี้ ทำการขุดลอกลำน้ำที่เกิดเหตุ ได้มีเจ้าหน้าที่ทราบชื่อภายหลังปรากฏตามบันทึกการจับกุมในคดีนี้ ได้เข้ามาขอตรวจสอบ พบว่าผู้ต้องหาไม่ได้รับอนุญาตจากเจ้าท่า จึงได้ยึดรถดังกล่าวไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพ จึงถูกจับกุม นำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุผู้กล่าวหากับพวกได้ออกตรวจพื้นที่ที่รับผิดชอบ เมื่อมาถึงที่เกิดเหตุพบผู้ต้องหากำลังใช้รถแบ็คโค ซึ่งภายหลังได้ยึดไว้เป็นของกลางปรากฏตามบัญชีของกลางในคดีนี้ ทำการขุดลอกลำน้ำที่เกิดเหตุ จึงได้เข้าตรวจสอบ พบว่าผู้ต้องหาไม่ได้รับอนุญาตจากเจ้าท่า จึงได้ยึดรถดังกล่าวไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพ จึงได้จับกุมผู้ต้องหา นำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	9	,	'เสพและมียาบ้าไว้ในครอบครอง'	,	'เจ้าหน้าที่ชุดจับกุม ตรวจพบผู้ต้องหาในที่เกิดเหตุ ตรวจพบยาบ้าของกลางอยู่ในความครอบครอง และได้นำไปตรวจปัสสาวะเบื้องต้นพบสารเสพติด โดยผู้ต้องหามีและเสพยาบ้าโดยไม่ได้รับอนุญาต จึงจับกุมส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหาอยู่ในที่เกิดเหตุ ได้มีเจ้าหน้าที่ชุดจับกุม ภายหลังทราบชื่อปรากฏรายชื่อตามบันทึกการจับกุมในคดีนี้ ได้เข้ามาแสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้นผู้ต้องหา ซึ่งเจ้าหน้าที่ดังกล่าวได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูก่อนแล้ว ผลการตรวจค้น เจ้าหน้าที่ฯ พบยาบ้าอยู่ในความครอบครองของผู้ต้องหา ปรากฏรายละเอียดตามบัญชีของกลางในคดีนี้ จึงถูกยึดไว้เป็นของกลาง และนำผู้ต้องหาไปตรวจปัสสาวะเบื้องต้น ผลการตรวจปัสสาวะ พบเมทแอมเฟตามีนในปัสสาวะของผู้ต้องหา ซึ่งผู้ต้องหารับว่าได้เสพยาบ้ามาก่อน โดยเสพครั้งสุดท้ายในวันก่อนถูกจับกุม เมื่อเวลาประมาณ ๑๐.๐๐ น. ที่บ้านพักของผู้ต้องหา ในปริมาณ ๑ เม็ด โดยวิธีเผายาบ้าในกระดาษฟรอยด์แล้วสูดดมเอากลิ่นไอ เจ้าหน้าที่ฯ จึงได้แจ้งข้อกล่าวหาให้ทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงถูกจับกุม พร้อมกับนำยาบ้าดังกล่าวและตัวอย่างปัสสาวะของผู้ต้องหา ส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหาและพวกปรากฏรายชื่อตามบันทึกการจับกุมในคดีนี้ ได้ออกตรวจตราและรักษาความสงบเรียบร้อยทั่วไปในที่เกิด พบผู้ต้องหา มีท่าทางเป็นพิรุธคล้ายผู้ติดยาเสพติด จึงได้แสดงตนเป็นเจ้าหน้าที่ขอตรวจค้นผู้ต้องหา ซึ่งผู้กล่าวหากับพวกได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูก่อนแล้ว ผลการตรวจค้นพบยาบ้าอยู่ในครอบครองของผู้ต้องหาจึงยึดไว้เป็นของกลาง ปรากฏรายละเอียดตามบัญชีของกลางในคดีนี้ จากนั้นได้นำผู้ต้องหาไปตรวจปัสสาวะเบื้องต้น ผลการตรวจปัสสาวะ พบเมทแอมเฟตามีนในปัสสาวะ และได้สอบถามผู้ต้องหาแล้วรับว่ามีและได้เสพยาบ้าโดยฝ่าฝืนกฎหมาย จึงแจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพ จึงจับกุมผู้ต้องหานำยาบ้าและตัวอย่างปัสสาวะของผู้ต้องหา ส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	10	,	'รับแจ้งจากสายลับว่าจะมีการนำยาบ้าผ่านที่เกิดเหตุ ไปตั้งจุดตรวจจุดสกัด'	,	'เจ้าหน้าที่ชุดจับกุมได้รับแจ้งจากสายลับว่าจะมีผู้นำยาเสพติดให้โทษ (ยาบ้า) ผ่านมายังที่เกิดเหตุ จึงได้ร่วมกันออกตรวจยังที่เกิดเหตุ ต่อมาตามวันเวลาที่เกิดเหตุพบผู้ต้องหาตรงกับที่ได้รับแจ้งจากสายลับ จึงได้ขอตรวจค้น ผลการตรวจค้นพบ ยาเสพติดให้โทษ(ยาบ้า) อยู่ในความครอบครองโดยที่ผู้ต้องหาไม่ได้รับอนุญาตให้มีไว้ในครอบครอง จึงจับกุมผู้ต้องหาส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหาผ่านมายังที่เกิดเหตุ ได้มีผู้กล่าวหากับพวก ทราบชื่อภายหลังปรากฏตามบันทึกการจับกุมในคดีนี้ ได้เข้ามาแสดงตนเป็นเจ้าหน้าที่ตำรวจ ขอตรวจค้นผู้ต้องหา ซึ่งผู้ต้องหายินยอมให้ตรวจค้นแต่โดยดี ซึ่งก่อนจะลงมือตรวจค้น ได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูจนเป็นที่พอใจก่อนแล้ว ผลการตรวจค้นเจ้าหน้าที่ฯ พบยาเสพติดให้โทษ(ยาบ้า) อยู่ในความครอบครองของผู้ต้องหา ซึ่งยาบ้าดังกล่าวเป็นของผู้ต้องหา มีไว้ในครอบครองโดยไม่ได้รับอนุญาต เจ้าหน้าที่จึงได้ยึดไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหารับทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงได้ถูกจับกุม นำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ก่อนเกิดเหตุในคดีนี้ ผู้กล่าวหาได้รับแจ้งจากสายลับว่า จะมีผู้นำยาเสพติดให้โทษ(ยาบ้า) ผ่านมายังที่เกิดเหตุ จึงได้รายงานให้ผู้บังคับบัญชาทราบ แล้วพร้อมกับพวกปรากฏรายชื่อตามบันทึกการจับกุมในคดีนี้ จึงไปตั้งจุดตรวจจุดสกัดยังที่เกิดเหตุ ต่อมาตามวันเวลาที่เกิดเหตุได้พบผู้ต้องหาตรงกับที่สายลับแจ้งมายังที่เกิดเหตุ จึงได้แสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้น ซึ่งก่อนจะลงมือตรวจค้น ได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูจนเป็นที่พอใจก่อนแล้ว ผลการตรวจค้นผู้กล่าวหากับพวกพบยาเสพติดให้โทษ(ยาบ้า) อยู่ในความครอบครองของผู้ต้องหา ซึ่งสอบถามผู้ต้องหาแล้วให้การว่ายาบ้าดังกล่าวเป็นของตน มีไว้ในครอบครองโดยไม่ได้รับอนุญาต จึงได้ยึดไว้เป็นของกลาง รายละเอียดปรากฏตามบัญชีของกลางในคดีนี้ แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหารับทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงได้จับกุมผู้ต้องหา นำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	11	,	'ยาบ้าเพื่อจำหน่าย ผู้ต้องหาโดยสารมากับรถโดยสารประจำทาง'	,	'ตามวันเวลาที่เกิดเหตุ เจ้าหน้าที่ชุดจับกุมได้ร่วมกันตั้งจุดตรวจในที่เกิดเหตุ ทำการตรวจค้นรถโดยสารที่ผ่านไปมา พบผู้ต้องหามียาเสพติดให้โทษประเภท ๑ (ยาบ้า)ไว้ในครอบครองโดยไม่ได้รับอนุญาต จึงจับกุมนำส่งพนักงานสอบดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหาโดยสารรถยนต์ประจำทางมาในที่เกิดเหตุ ได้มีเจ้าหน้าที่ชุดจับกุม ภายหลังทราบชื่อปรากฏตามบันทึกการจับกุมในคดีนี้ ได้เข้ามาแสดงตนขอตรวจค้นผู้ต้องหา ซึ่งก่อนลงมือตรวจค้นได้แสดงความบริสุทธิ์ใจแก่ผู้ต้องหาจนเป็นที่พอใจแล้ว ผลการตรวจค้นเจ้าหน้าที่ฯ พบยาเสพติดให้โทษ(ยาบ้า) ปรากฏตามบัญชีของกลางในคดีนี้ อยู่ในความครอบครองของผู้ต้องหา จึงได้ยึดไว้เป็นของกลางและจับกุมผู้ต้องหา นำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี ชั้นจับกุมผู้ต้องหาได้ให้การรับสารภาพตลอดข้อกล่าวหา'	,	'ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหากับพวก ได้ร่วมกันตั้งจุดตรวจจุดสกัดในที่เกิดเหตุ ได้พบผู้ต้องหาโดยสารรถยนต์ประจำทางมาในที่เกิดเหตุ มีท่าทางเป็นพิรุธ จึงได้ขอตรวจค้นผู้ต้องหา ซึ่งก่อนลงมือตรวจค้นได้แสดงความบริสุทธิ์ใจแก่ผู้ต้องหาจนเป็นที่พอใจแล้ว ผลการตรวจค้นผู้กล่าวหาพบยาเสพติดให้โทษ (ยาบ้า) ปรากฏตามบัญชีของกลางในคดีนี้ อยู่ในความครอบครองของผู้ต้องหา จึงได้ยึดไว้เป็นของกลางและจับกุมผู้ต้องหา นำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	12	,	'เสพยาบ้า ตรวจปัสสาวะ (จับกุมตัวทันที) ออกตรวจพบผู้ต้องหา'	,	'เจ้าหน้าที่ชุดจับกุม ตรวจพบผู้ต้องหาในที่เกิดเหตุ นำไปตรวจปัสสาวะเบื้องต้นพบ พบเมทแอมเฟตามีนในปัสสาวะ เชื่อว่าผู้ต้องหาได้เสพยาบ้าโดยฝ่าฝืนกฎหมาย จึงจับกุมส่งพนักงานสอบสวนดำเนินคดีต่อไป'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหาอยู่ในที่เกิดเหตุ ได้มีเจ้าหน้าที่ชุดจับกุม ภายหลังทราบชื่อปรากฏรายชื่อตามบันทึกการจับกุมในคดีนี้ ได้เข้ามาแสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้นผู้ต้องหา ซึ่งเจ้าหน้าที่ดังกล่าวได้แสดง'	,	'ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหาและพวกปรากฏรายชื่อตามบันทึกการจับกุมในคดีนี้ ได้ออกตรวจรักษาความสงบเรียบร้อยในที่เกิดเหตุตามหน้าที่ ได้พบผู้ต้องหาอยู่ในที่เกิดเหตุ มีท่าทางเป็นพิรุธคล้ายผู้ติดยาเสพติดให้โทษ จึงได้แสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้น ซึ่งผู้ต้องหายินยอมให้ตรวจค้น โดยก่อนตรวจค้นผู้กล่าวหากับพวกได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูจนเป็นที่พอใจก่อนแล้ว ผลการตรวจค้นไม่พบสิ่งของผิดกฎหมาย แต่ผู้ต้องหารับว่าเป็นผู้ติดยาเสพติดให้โทษ จึงได้นำผู้ต้องหาไปตรวจปัสสาวะกับชุดตรวจเมทแอมเฟตามีนขององค์การเภสัชกรรม ซึ่งให้ผลบวกกับชุดตรวจดังกล่าว จึงได้นำตัวอย่างปัสสาวะของผู้ต้องหาไปตรวจยืนยันผลที่โรงพยาบาลแม่แตง ผลการตรวจยังคงพบเมทแอมเฟตามีนในปัสสาวะของผู้ต้องหา จึงเชื่อว่าผู้ต้องหาเสพยาบ้าโดยฝ่าฝืนต่อกฎหมายจริง จึงได้แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงจับกุมผู้ต้องหาและนำตัวอย่างปัสสาวะของผู้ต้องหา ส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	13	,	'มีอาวุธปืน เครื่องกระสุนปืน และพกพา'	,	'ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหาพร้อมกับพวกออกตรวจในที่เกิดเหตุ พบผู้ต้องหามีท่าทีเป็นพิรุธ จึงได้แสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้นผู้ต้องหา ซึ่งผู้ต้องหายินยอมให้ตรวจค้นแต่โดยดี ผลการตรวจค้น ผู้กล่าวหากับพวกพบอาวุธปืน เครื่องกระสุนปืน ปรากฏตามบัญชีของกลางในคดีนี้ อยู่ที่เอวของผู้ต้องหา สอบถามผู้ต้องหาไม่ได้รับอนุญาตให้มีซึ่งอาวุธปืนและเครื่องกระสุนปืนดังกล่าว และไม่มีใบอนุญาตให้พกพา จึงจับกุมผู้ต้องหาส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหาอยู่ในที่เกิดเหตุ ได้มีเจ้าหน้าที่ตำรวจ ทราบชื่อภายหลัง ปรากฏตามบันทึกการจับกุมในคดีนี้ จึงได้เข้ามาแสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้นผู้ต้องหา ซึ่งผู้ต้องหายินยอมให้ตรวจค้นแต่โดยดี โดยก่อนตรวจค้นได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูจนเป็นที่พอใจแล้ว ผลการตรวจค้น ผู้กล่าวหากับพวกพบอาวุธปืน และเครื่องกระสุนปืน ภายหลังได้ตรวจยึดไว้เป็นของกลาง ปรากฏตามบัญชีของกลางในคดีนี้ อยู่ที่เอวของผู้ต้องหา ซึ่งผู้ต้องหาไม่ได้รับอนุญาตให้มีซึ่งอาวุธปืนและเครื่องกระสุนปืนดังกล่าว และไม่มีใบอนุญาตให้พกพา จึงถูกจับกุมตัวส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหาพร้อมกับพวกออกตรวจในที่เกิดเหตุ พบผู้ต้องหามีท่าทีเป็นพิรุธ จึงได้แสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้นผู้ต้องหา ซึ่งผู้ต้องหายินยอมให้ตรวจค้นแต่โดยดี โดยก่อนตรวจค้นได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูจนเป็นที่พอใจแล้ว ผลการตรวจค้น ผู้กล่าวหากับพวกพบอาวุธปืน และเครื่องกระสุนปืน ภายหลังได้ตรวจยึดไว้เป็นของกลาง ปรากฏตามบัญชีของกลางในคดีนี้ อยู่ที่เอวของผู้ต้องหา ซึ่งผู้ต้องหาได้พกพามาในที่เกิดเหตุ สอบถามผู้ต้องหาไม่ได้รับอนุญาตให้มีซึ่งอาวุธปืนและเครื่องกระสุนปืนดังกล่าว และไม่มีใบอนุญาตให้พกพา จึงจับกุมผู้ต้องหาพร้อมนำของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	14	,	'ร่วมกันลักทรัพย์ในเคหสถานในเวลากลางคืนใช้ยานพาหนะหรือรับของโจร'	,	'ผู้ต้องหาที่ ๑ ได้ร่วมกับผู้ต้องหาที่ ๒ เข้าไปลักทรัพย์ ปรากฏตามบัญชีทรัพย์ถูกประทุษร้ายในคดีนี้ ของผู้เสียหาย โดยใช้รถจักรยานยนต์เป็นพาหนะ ต่อมาเจ้าหน้าที่ชุดจับกุม สามารถติดตามจับกุมผู้ต้องหาทั้งสองได้พร้อมด้วยทรัพย์ของกลางที่ลักไป จึงนำส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ผู้ต้องหาที่ ๑ ได้ขับขับขี่รถจักรยานยนต์ เข้าไปในที่เกิดเหตุ โดยมีผู้ต้องหาที่ ๒ เป็นผู้ซ้อนท้าย เพื่อไปหาลักเอาทรัพย์ของผู้เสียหายนำไปจำหน่าย ผู้ต้องหาได้เข้าไปในที่เกิดเหตุซึ่งได้เปิดประตูทิ้งไว้ และลักเอาทรัพย์ของกลางซึ่งภายหลังถูกยึดไว้เป็นของกลางปรากฏตามบัญชีของกลางในคดีนี้ ภายในที่เกิดเหตุ แล้วบรรทุกใส่รถจักรยานยนต์ ซึ่งมีผู้ต้องหาที่ ๑ เป็นคนขับขี่ และมีผู้ต้องหาที่ ๒ เป็นผู้ซ้อนท้ายนำทรัพย์ที่ลักมาไปขายให้กับร้านรับซื้อของเก่าแล้วนำเงินมาแบ่งกันใช้จนหมดไปแล้ว ต่อมาได้มีเจ้าหน้าที่ตำรวจติดตามมาพบผู้ต้องหา จึงรับว่าได้เข้าไปลักทรัพย์ของผู้เสียหายจริง และได้ร่วมกันพาไปเอาทรัพย์สินที่ลักไป จึงได้ถูกจับกุมส่งพนักงานสอบสวนดำเนินคดี ชั้นจับกุมผู้ต้องหาให้การรับสารภาพ และไม่ขอโต้แย้งในทรัพย์สินของกลางแต่อย่างใด'	,	'ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหาได้พักผ่อนหลับนอนในที่เกิดเหตุ โดยได้สำรวจดูทรัพย์สินทั้งหมดก่อนแล้วว่ายังอยู่ครบ ครั้นพอตื่นขั้นมา พบว่าทรัพย์สินปรากฏตามบัญชีทรัพย์ถูกประทุษร้ายในคดีนี้ได้หายไป ผู้กล่าวหาเชื่อว่าคนร้ายจะต้องเป็นผู้ต้องหาในคดีนี้ ซึ่งเห็นป้วนเปี้ยน และเข้ามาคุยกับผู้กล่าวหาก่อนที่จะเกิดเหตุในคดีนี้ไม่นานนัก ต่อมาเจ้าหน้าที่ชุดจับกุมสามารถจับกุมผู้ต้องหาทั้งสองได้พร้อมด้วยทรัพย์ของกลาง จึงได้ติดตามมาดูและยืนยันว่าเป็นทรัพย์สินของผู้กล่าวหาที่หายไป และได้สอบถามผู้ต้องหาทั้งสองรับว่าได้ร่วมกันลักทรัพย์ดังกล่าวของผู้กล่าวหาไปจริง จึงขอรับกลับไปโดยที่ผู้ต้องหาทั้งสองไม่โต้แย้งในกรรมสิทธิ์ทรัพย์สินของกลางแต่อย่างใด'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	15	,	'ร่วมกันมียาบ้าเพื่อจำหน่ายรับแจ้งจากสายผู้ต้องหาสองคนมากับรถจักรยานยนต์ยึดรถ'	,	'เจ้าหน้าที่ชุดจับกุม ได้รับแจ้งจากสายว่าจะมีผู้ขับขี่รถจักรยานยนต์และซ้อนท้ายกันมา นำยาบ้าผ่านที่เกิดเหตุเพื่อไปจำหน่าย จึงได้ออกไปตั้งจุดตรวจจุดสกัดในที่เกิดเหตุ พบผู้ต้องหาสองคนขับขี่และซ้อนท้ายรถจักรยานยนต์มาในที่เกิดเหตุ ตรวจพบยาบ้าของกลางอยู่ในครอบครองของผู้ต้องหาทั้งสองโดยไม่ได้รับอนุญาตให้มีไว้ในครอบครองจึงยึดยาบ้าและรถที่ใช้ขับขี่ไว้เป็นของกลาง จับกุมผู้ต้องหาและนำของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุขณะที่ผู้ต้องหาที่ ๑ ขับขี่ รถจักรยานยนต์ ซึ่งภายหลังถูกยึดไว้ปรากฏตามบัญชีของกลางในคดีนี้ โดยมีผู้ต้องหาที่ ๒ เป็นผู้ซ้อนท้าย ผ่านที่เกิดเหตุ ได้พบกับเจ้าหน้าที่ชุดปรากฏตามบันทึกการจับกุมในคดีนี้ ได้เรียกให้หยุด แล้วแสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้น ซึ่งผู้ต้องหากับพวกได้ยินยอมให้ตรวจค้นโดยดี โดยก่อนการตรวจค้นได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหากับพวกดูจนเป็นที่พอใจก่อนแล้ว ผลการตรวจค้น พบยาเสพติดของกลางปรากฏตามบัญชีของกลางในคดีนี้ อยู่ในครอบครองของผู้ต้องหาทั้งสอง เจ้าหน้าที่จึงได้ยึดไว้เป็นของกลาง ซึ่งผู้ต้องหารับว่าของกลางดังกล่าวเป็นยาเสพติดให้โทษยาบ้า ของผู้ต้องหาทั้งสอง มีไว้เพื่อจำหน่ายให้กับผู้ติดยาเสพติดทั่วไป และได้มาโดยร่วมกันออกเงินซื้อมา จากชายไม่ทราบชื่อ เพื่อเอาไว้แบ่งกันเสพ ผู้กล่าวหาจึงได้แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบผู้ต้องหารับทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงจับกุมผู้ต้องหานำส่งพนักงานสอบสวนดำเนินคดีพร้อมกับของกลางดังกล่าว'	,	'ก่อนเกิดเหตุ ผู้กล่าวหากับพวก ได้รับแจ้งจากสายว่าจะมีผู้ขับขี่รถจักรยานยนต์และซ้อนท้ายกันมา นำยาบ้าผ่านที่เกิดเหตุเพื่อไปจำหน่าย จึงได้ออกไปตั้งจุดตรวจจุดสกัดในที่เกิดเหตุ ต่อมาตามวันเวลาที่เกิดเหตุ พบว่ามีผู้ขับขี่ รถจักรยานยนต์ ปรากฏตามบัญชีของกลางในคดีนี้ ผ่านที่เกิดเหตุ ตามที่ได้รับแจ้งจากสาย จึงได้เรียกให้หยุด แล้วแสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้น พบว่าผู้ต้องหาที่ ๑ เป็นผู้ขับขี่ ผู้ต้องหาที่ ๒ เป็นผู้ซ้อนท้าย ผู้ต้องหาทั้งสองได้ยินยอมให้ผู้กล่าวหากับพวกตรวจค้นโดยดี ผลการตรวจค้น พบยาเสพติดของกลางปรากฏตามบัญชีของกลางในคดีนี้ อยู่ในครอบครองของผู้ต้องหาทั้งสอง จึงได้สอบถามผู้ต้องหาทั้งสอง ซึ่งผู้ต้องหาทั้งสองรับว่าของกลางดังกล่าวเป็นยาเสพติดให้โทษของผู้ต้องหาทั้งสอง มีไว้เพื่อทดลองเสพ และได้มาโดยร่วมกันออกเงินซื้อมา จากชายไม่ทราบชื่อ เพื่อเอาไว้แบ่งกันเสพ ผู้กล่าวหาจึงได้แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบผู้ต้องหาทั้งสองรับทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงจับกุมผู้ต้องหานำส่งพนักงานสอบสวนดำเนินคดีพร้อมกับยาเสพติดของกลาง'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	16	,	'ร่วมกันเล่นการพนันไพ่แปดเก้า (ไพ่เก้า)'	,	'เจ้าหน้าที่ออกตรวจพบผู้ต้องหากับพวกกำลังลักลอบเล่นการพนันไพ่แปดเก้า(ไพ่เก๊า) โดยใช้อุปกรณ์ในการเล่นการพนัน ปรากฏตามบัญชีของกลางในดีนี้ เป็นอุปกรณ์ในการเล่นการพนัน โดยมีผู้ต้องหาที่ ๑ เป็นเจ้ามือรับกินรับใช้ พนันเอาทรัพย์สินกันโดยไม่ได้รับอนุญาต จึงจับกุมส่งพนักงานสอบสวนดำเนินคดี'	,	'ขณะที่ผู้ต้องหากับพวกกำลังลักลอบเล่นการพนันไพ่แปดเก้า(ไพ่เก๊า) โดยใช้อุปกรณ์ในการเล่นการพนัน ปรากฏตามบัญชีของกลางในดีนี้ เล่นการเล่นการพนัน พนันเอาทรัพย์สินกันโดยไม่ได้รับอนุญาต โดยมีผู้ต้องหาที่ ๑ เป็นเจ้ามือรับกินรับใช้ เจ้าหน้าที่ชุดจับกุมตรวจพบ จึงจับกุมส่งพนักงานสอบสวนดำเนินคดี ชั้นจับกุมผู้ต้องหาได้ให้การรับสารภาพตลอดข้อกล่าวหา'	,	'ผู้กล่าวหากับพวกปรากฏชื่อตามบันทึกการจับกุมในคดีนี้ ออกตรวจพื้นที่ที่รับผิดชอบ เมื่อมาถึงที่เกิดเหตุ พบผู้ต้องหากับพวกกำลังลักลอบเล่นการพนันไพ่แปดเก้า(ไพ่เก๊า) โดยใช้อุปกรณ์ในการเล่นการพนัน ปรากฏตามบัญชีของกลางในดีนี้ เป็นอุปกรณ์ในการเล่นการพนัน พนันเอาทรัพย์สินกันโดยไม่ได้รับอนุญาต โดยมีผู้ต้องหาที่ ๑ เป็นเจ้ามือรับกินรับใช้ จึงจับกุมผู้ต้องหาส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	17	,	'ยาบ้าเพื่อจำหน่ายรับแจ้งจากสายผู้ต้องหาขับขี่รถจักรยานยนต์ยึดรถของกลาง(รับแจ้งจากสายลับ)'	,	'เจ้าหน้าที่ชุดจับกุม ได้รับแจ้งจากสายลับว่าจะมีผู้นำยาบ้าผ่านมาในที่เกิดเหตุ จึงได้ไปยังที่เกิดเหตุ และพบผู้ต้องหาขับขี่รถจักรยานยนต์มาในที่เกิดเหตุ ตรวจพบยาบ้าของกลางอยู่ในครอบครองของผู้ต้องหา โดยไม่ได้รับอนุญาตให้มีไว้ในครอบครองจึงยึดยาบ้าและรถที่ใช้ขับขี่ไว้เป็นของกลาง จับกุมผู้ต้องหาและนำของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุขณะที่ผู้ต้องหา ขับขี่รถจักรยานยนต์ ซึ่งภายหลังถูกยึดไว้ปรากฏตามบัญชีของกลางในคดีนี้ ผ่านที่เกิดเหตุ ได้พบกับเจ้าหน้าที่ชุดปรากฏตามบันทึกการจับกุมในคดีนี้ ได้เรียกให้หยุด แล้วแสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้น ซึ่งผู้ต้องหายินยอมให้ตรวจค้นโดยดี โดยก่อนการตรวจค้นได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูจนเป็นที่พอใจก่อนแล้ว ผลการตรวจค้น พบยาเสพติดของกลางปรากฏตามบัญชีของกลางในคดีนี้ อยู่ในครอบครองของผู้ต้องหา เจ้าหน้าที่จึงได้ยึดไว้เป็นของกลาง ซึ่งผู้ต้องหารับว่าของกลางดังกล่าวเป็นยาเสพติดให้โทษของผู้ต้องหามีไว้ในครองครองโดยไม่ได้รับอนุญาต เพื่อเอาไว้จำหน่าย ซึ่งเพิ่งซื่อมาจากผู้มีชื่อ ผู้กล่าวหาจึงได้แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบผู้ต้องหารับทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงได้ถูกจับกุมส่งพนักงานสอบสวนดำเนินคดีพร้อมกับของกลางยาบ้าและรถจักรยานยนต์ที่ผู้ต้องหาได้ใช้ในการไปหาซื้อยาบ้า ปรากฏรายละเอียดตามบัญชีของกลางในคดีนี้'	,	'ก่อนเกิดเหตุผู้กล่าวหาและพวก ปรากฏชื่อตามบันทึกการจับกุมในคดีนี้ ได้รับแจ้งจากสายลับ(ขอปิดนาม) ว่าจะมีผู้นำยาบ้าผ่านที่เกิดเหตุโดยใช้รถจักรยานยนต์ จึงได้ไปยังที่เกิดเหตุ ต่อมาตามวันเวลาที่เกิดเหตุพบว่ามีผู้ขับขับขี่รถจักรยานยนต์ ผ่านที่เกิดเหตุ ตรงตามที่ได้รับแจ้งจากสายลับ จึงได้เรียกให้หยุด แล้วแสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้น ซึ่งผู้ต้องหายินยอมให้ผู้กล่าวหากับพวกตรวจค้นโดยดี ผลการตรวจค้น พบยาเสพติดของกลางปรากฏตามบัญชีของกลางในคดีนี้ อยู่ในครอบครองของผู้ต้องหา จึงได้สอบถามผู้ต้องหาถึงยาบ้าดังกล่าว ซึ่งผู้ต้องหารับว่าเป็นยาเสพติดให้โทษของผู้ต้องหามีไว้ในครอบครองโดยไม่ได้รับอนุญาต ซื้อมาจากผู้มีชื่อ เพื่อเอาไว้จำหน่าย ผู้กล่าวหาจึงได้ยึดยาบ้าและรถจักรยานยนต์ที่ผู้ต้องหาใช้ในการทำผิดโดยการนำไปซื้อยาบ้า ไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบผู้ต้องหารับทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงจับกุมผู้ต้องหานำผู้ต้องหาพร้อมของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	18	,	'เสพยาเสพติดในขณะขับขี่รถจักรยานยนต์ (เสพขับ)'	,	'เจ้าหน้าที่ชุดจับกุม ได้ตั้งจุดตรวจที่เกิดเหตุตามหน้าที่ พบผู้ต้องหาขับขี่รถจักรยานยนต์มาในที่เกิดเหตุ มีพิรุธจึงได้นำตัวไปตรวจหาสารเสพติดพบว่ามีเมทแอมเฟตามีนในปัสสาวะ จับกุมผู้ต้องหาและนำตัวอย่างปัสสาวะของผู้ต้องหาส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุขณะที่ผู้ต้องหาขับขี่รถจักรยานยนต์ ผ่านที่เกิดเหตุ ได้พบกับเจ้าหน้าที่ชุดจับกุม ทราบชื่อภายหลังปรากฏตามบันทึกการจับกุมในคดีนี้ ได้เรียกให้หยุด แล้วแสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้น ซึ่งผู้ต้องหายินยอมให้ตรวจค้นโดยดี โดยก่อนการตรวจค้นได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูจนเป็นที่พอใจก่อนแล้ว ผลการตรวจค้นไม่พบสิ่งผิดกฎหมายใดๆ แต่ผู้ต้องหารับว่าเป็นผู้เสพยาเสพติดยาบ้า โดยเสพครั้งสุดท้ายในช่วงก่อนเที่ยงของวันก่อนถูกจับกุมที่บ้านพักของผู้ต้องหา จำนวน ๑ เม็ด โดยวิธีเผาไฟบนกระดาษฟรอยด์แล้วสูดดมเอากลิ่นไอ จึงได้ถูกนำตัวไปตรวจปัสสาวะ ผลการตรวจปัสสาวะของผู้ต้องหาพบเมทแอมเฟตามีนในปัสสาวะ จึงถูกจับกุมผู้ต้องหานำส่งพนักงานสอบสวนดำเนินคดีพร้อมกับตัวอย่างปัสสาวะของผู้ต้องหา ชั้นจับกุมผู้ต้องหาได้ให้การรับสารภาพตลอดข้อกล่าวหา'	,	'ตามวันเวลาที่เกิดเหตุขณะที่ผู้กล่าวหากับพวกปรากฏชื่อตามบันทึกการจับกุมในคดีได้ตั้งจุดตรวจในที่เกิดเหตุ พบผู้ต้องหาขับขี่รถจักรยานยนต์ผ่านที่เกิดเหตุ จึงได้เรียกให้หยุด แล้วแสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้น ซึ่งผู้ต้องหายินยอมให้ผู้กล่าวหากับพวกตรวจค้นโดยดี ผลการตรวจค้น ไม่พบสิ่งผิดกฎหมายใดๆ แต่ผู้ต้องหารับว่าเป็นผู้เสพยาเสพติดยาบ้า จึงได้นำตัวไปตรวจปัสสาวะ ผลการตรวจปัสสาวะของผู้ต้องหาพบเมทแอมเฟตามีน เชื่อว่าได้เสพยาบ้าจริง จึงได้แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหารับทราบข้อกล่าวหาแล้วให้การรับสารภาพ จึงจับกุมผู้ต้องหานำส่งพนักงานสอบสวนดำเนินคดีพร้อมกับตัวอย่างปัสสาวะของผู้ต้องหา และรถจักรยานยนต์ที่ผู้ต้องหาขับขี่มา'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	19	,	'เช่าซื้อรถจักรยานยนต์ ยักยอกทรัพย์ มอบอำนาจให้มาแจ้ง'	,	'ผู้ต้องหาได้ไปเช่าซื้อรถจักรยานยนต์กับผู้เสียหาย ต่อมาได้ผู้ต้องหาไม่ยอมส่งค่างวด และได้จำหน่ายรถคันดังกล่าวให้ผู้อื่นไป ผู้เสียหายจึงได้มอบอำนาจให้ผู้กล่าวหามาแจ้งความร้องทุกข์ มอบคดีต่อพนักงานสอบสวนให้ดำเนินคดีกับผู้ต้องหา จนกว่าคดีจะถึงที่สุด'	,	'ตามวันเวลาที่เกิดเหตุ ผู้ต้องหาเช่าซื้อรถจักรยานยนต์กับผู้เสียหาย ปรากฏรายละเอียดตามสัญญาเช่าซื้อในคดีนี้ ต่อมาผู้ต้องหาได้จำหน่ายรถคันดังกล่าวให้ผู้อื่นไป และเมื่อถูกทวงถามคืน ผู้ต้องหาไม่สามารถนำรถคันดังกล่าวมาคืนแก่ผู้เสียหาย และทราบว่าผู้เสียหายได้มาแจ้งความร้องทุกข์ให้ดำเนินคดีกับผู้ต้องหา จึงมาพบพนักงานสอบสวนเพื่อมอบตัว ยอมรับผิดให้ดำเนินคดี'	,	'ผู้ต้องหาได้มาเช่าซื้อรถจักรยานยนต์จากตัวแทนของผู้เสียหาย รายละเอียดปรากฏตามสำเนาสัญญาเช่าซื้อในคดีนี้ ต่อมาผู้ต้องหางดส่งค่างวดรถ ผู้เสียหายได้พยายามทวงถามตลอดมา แต่ผู้ต้องหาได้พยายามผัดผ่อนเรื่อยมาเช่นกัน และครั้งสุดท้ายได้ไปพบผู้ต้องหาที่ บ้านพัก แต่ไม่พบสอบถามบ้านข้างเคียง ได้ความว่าไม่พบผู้ต้องหาในบ้านพักนานแล้ว เชื่อว่าหลบหนี และไม่พบรถจักรยานยนต์ที่บ้านพักของผู้ต้องหา เชื่อว่าผู้ต้องหามีเจตนายักยอกทรัพย์รถจักรยานยนต์ของผู้เสียหาย ผู้กล่าวหาจึงได้รับมอบอำนาจจากผู้เสียหายให้มาแจ้งความร้องทุกข์มอบคดีต่อพนักงานสอบสวน ให้ดำเนินคดีกับผู้ต้องหาจนกว่าคดีจะถึงที่สุดต่อไป'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	20	,	'ร่วมกันลักทรัพย์ที่ใช้หรือมีไว้เพื่อสาธารณประโยชน์ หรือรับของโจร'	,	'ตามวันเวลาที่เกิดเหตุ ผู้ต้องหาที่ ๑ และผู้ต้องหาที่ ๒ ได้ร่วมกันลักเอาทรัพย์ รายละเอียดปรากฏตามบัญชีทรัพย์ถูกประทุษร้ายในคดีนี้ ซึ่งเป็นทรัพย์สินของราชการ มีไว้ใช้หรือมีไว้เพื่อสาธารณะประโยชน์ แล้วหลบหนีไป ภายหลังเจ้าหน้าที่ตำรวจจับกุมผู้ต้องหาได้ จึงนำส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ผู้ต้องหาที่ ๑ และผู้ต้องหาที่ ๒ ได้ร่วมกันลักเอาทรัพย์ รายละเอียดปรากฏตามบัญชีทรัพย์ถูกประทุษร้ายในคดีนี้ ซึ่งเป็นทรัพย์สินของราชการ มีไว้ใช้หรือมีไว้เพื่อสาธารณะประโยชน์ แล้วหลบหนีไป ภายหลังเจ้าหน้าที่ตำรวจจับกุมผู้ต้องหาที่ ๑ และผู้ต้องหาที่ ๒ ได้ จึงนำส่งพนักงานสอบสวนดำเนินคดี'	,	'ผู้กล่าวหาเป็นเจ้าหน้าที่ส่วนราชการ มีหน้าที่ดูแลทรัพย์สินที่ถูกประทุษร้ายไปในคดีนี้ ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหาตรวจพบว่าทรัพย์สินดังกล่าวได้หายไป เชื่อว่าจะต้องมีคนร้ายมาลักไป จึงได้มาแจ้งความร้องทุกข์ต่อพนักงานสอบสวน ให้สืบสวนหาตัวคนร้าย และทรัพย์สินที่หายไปมาดำเนินคดีต่อไป'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	21	,	'ลักทรัพย์, ใช้บัตรอิเล็กทรอนิกส์ของผู้อื่นโดยมิชอบ'	,	'ตามวันเวลาที่เกิดเหตุ ผู้ต้องหาได้ลักเอา บัตรเดบิต ซึ่งเป็นบัตรอิเล็กทรอนิกส์ตามกฎหมายที่ธนาคารได้ออกให้แก่ผู้เสียหายไป โดยทุจริต และต่อมาได้เอาบัตรดังกล่าว ไปใช้อ้างแสดงต่อพนักงานแคชเชียร์เก็บเงินของห้างร้าน ชำระราคาค่าสินค้า(เครื่องอุปโภคบริโภค) แทนการชำระด้วยเงินสด ต่อมาเจ้าหน้าที่ตำรวจจับกุมตัวผู้ต้องหาได้ จึงถูกนำส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ผู้ต้องหาได้บังอาจลักเอา บัตรเดบิต ซึ่งเป็นบัตรอิเล็กทรอนิกส์ตามกฎหมายที่ธนาคารได้ออกให้แก่ผู้กล่าวหาไป เพื่อแสดงหาผลประโยชน์ที่มิควรได้แต่ตน และต่อมาได้เอาบัตรดังกล่าว ไปใช้อ้างแสดงต่อพนักงานแคชเชียร์เก็บเงินของห้างร้าน ชำระราคาค่าสินค้า(เครื่องอุปโภคบริโภค) แทนการชำระด้วยเงินสด ต่อมาเจ้าหน้าที่ตำรวจจับกุมตัวผู้ต้องหาได้ จึงถูกนำส่งพนักงานสอบสวนดำเนินคดี'	,	'ผู้กล่าวหาได้ตรวจสอบพบว่า เงินในธนาคารของผู้กล่าวหาได้หายไป เป็นจำนวนเงินปรากฏตามบัญชีทรัพย์ที่ถูกประทุษร้ายในคดีนี้ ซึ่งผู้กล่าวหาเชื่อว่ามีผู้ลักเอาบัตรเดบิต ซึ่งเป็นบัตรอิเล็กทรอนิกส์ตามกฎหมายที่ธนาคารได้ออกให้แก่ผู้กล่าวหา แล้วนำไปเบิกเงิน หรือชำระราคาสินค้า และผู้ที่ลักไปจะต้องเป็นผู้ต้องหาในคดีนี้ เนื่องจากมีความคุ้นเคยกับผู้กล่าวหา จึงได้มาแจ้งความร้องทุกข์ให้ติดตามตัวผู้ต้องหานี้มาดำเนินคดีต่อไป'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	22	,	'นำหมายค้นค้นบ้านพักของผู้ต้องหา พบยาเสพติดให้โทษประเภท 2 (ฝิ่น)'	,	'เจ้าหน้าที่ชุดจับกุม นำหมายค้นของศาลไปตรวจค้นบ้านพักของผู้ต้องหาซึ่งเป็นที่ เกิดเหตุในคดีนี้ พบผู้ต้องหามียาเสพติดให้โทษประเภท ๒ (ฝิ่น) อยู่ในครอบครองโดยไม่ได้รับอนุญาต จึงยึดไว้เป็นของกลาง จับกุมผู้ต้องหาพร้อมนำของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่อยู่ที่บ้านพักของผู้ต้องหา ได้มีเจ้าหน้าที่ชุดจับกุม ทราบชื่อภายหลังปรากฏตามบันทึกการจับกุมในคดีนี้ ได้นำหมายค้นของศาล มาขอตรวจค้นบ้านพักของผู้ต้องหา ผู้ต้องหาได้แสดงตนเป็นเจ้าของบ้าน และเป็นผู้นำทำการตรวจค้น โดยก่อนที่จะลงมือตรวจค้น เจ้าหน้าที่ผู้ตรวจค้น ได้แสดงความบริสุทธิ์ใจจนเป็นที่พอใจแก่ผู้ต้องหาแล้ว ผลการตรวจค้นผู้กล่าวหากับพวกพบยาเสพติดให้โทษประเภท ๒ (ฝิ่น) ปรากฏรายละเอียดตามบัญชีของกลางในคดีนี้ อยู่ในความครอบครองของผู้ต้องหา ซึ่งผู้ต้องหาไม่ได้รับอนุญาตให้มีไว้ในครอบครอง ผู้กล่าวหาได้แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงได้ถูกจับกุมนำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหากับพวกได้นำหมายค้นของศาล ไปทำการตรวจค้นบ้านพักของผู้ต้องหา ซึ่งเป็นที่เกิดเหตุในคดีนี้ เนื่องจากสืบทราบว่ามีสิ่งของผิดกฎหมายซุกซ่อนอยู่ พบผู้ต้องหาอยู่ภายในบ้านและแสดงตนเป็นเจ้าของบ้าน จึงได้แสดงหมายค้นให้ผู้ต้องหาดู และขอทำการตรวจค้น ซึ่งผู้ต้องหายินยอมให้ตรวจค้น และเป็นผู้นำทำการตรวจค้น โดยก่อนที่จะลงมือตรวจค้น ได้แสดงความบริสุทธิ์ใจจนเป็นที่พอใจแก่ผู้ต้องหาแล้ว ผลการตรวจค้นผู้กล่าวหากับพวกพบยาเสพติดให้โทษประเภท ๒ (ฝิ่น) ปรากฏรายละเอียดตามบัญชีของกลางในคดีนี้ อยู่ในความครอบครองของผู้ต้องหา ซึ่งผู้ต้องหารับว่าเป็นของผู้ต้องหา มีไว้ในครอบครองโดยไม่ได้รับอนุญาต จึงได้ยึดไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพ จึงได้จับกุมนำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	23	,	'ลักทรัพย์รถจักรยานยนต์ ไม่รู้ตัว'	,	'ตามวันเวลาที่เกิดเหตุ ได้มีคนร้ายเข้าไปลักทรัพย์ รถจักรยานยนต์ ซึ่งเป็นของผู้เสียหาย รายละเอียดปรากฏตามบัญชีทรัพย์ถูกประทุษร้ายในคดีนี้ ที่ผู้เสียหายได้จอดไว้ในที่เกิดเหตุ โดยไม่ปรากฏว่าผู้ใดเป็นผู้ร้าย ผู้เสียหายจึงได้มาแจ้งความร้องทุกข์ต่อพนักงานสอบสวน ให้สืบสวนหาทรัพย์ที่หายไป และติดตามตัวคนร้ายมาดำเนินคดีต่อไป'	,	''	,	'ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหาได้จอดรถจักรยานยนต์ ซึ่งเป็นทรัพย์สินของผู้กล่าวหา รายละเอียดปรากฏตามบัญชีทรัพย์ถูกประทุษร้ายในคดีนี้ ไว้ในที่เกิดเหตุ แล้วได้ออกจากที่เกิดเหตุไปเพื่อไปทำธุระ ภายหลังผู้กล่าวหาได้กลับเข้ามายังที่เกิดเหตุอีกครั้ง ปรากฏว่ารถคันดังกล่าวได้หายไป ผู้กล่าวหาได้ติดตามและสอบถามไปยังที่ต่างๆแล้ว ไม่มีผู้ใดทราบเหตุ ผู้กล่าวหาเชื่อว่าจะต้องมีคนร้ายมาลักเอาไป จึงได้มาแจ้งความร้องทุกข์ ต่อพนักงานสอบสวน ให้สืบสวนหาทรัพย์ที่หายไป และติดตามตัวคนร้ายมาดำเนินคดีต่อไป'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	24	,	'ลักทรัพย์รถยนต์ ไม่รู้ตัว'	,	'ตามวันเวลาที่เกิดเหตุ ได้มีคนร้ายเข้าไปลักทรัพย์ รถยนต์ ซึ่งเป็นของผู้เสียหาย รายละเอียดปรากฏตามบัญชีทรัพย์ถูกประทุษร้ายในคดีนี้ ที่ผู้เสียหายได้จอดไว้ในที่เกิดเหตุ โดยไม่ปรากฏว่าผู้ใดเป็นผู้ร้าย ผู้เสียหายจึงได้มาแจ้งความร้องทุกข์ต่อพนักงานสอบสวน ให้สืบสวนหาทรัพย์ที่หายไป และติดตามตัวคนร้ายมาดำเนินคดีต่อไป'	,	''	,	'ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหาได้จอดรถยนต์ ซึ่งเป็นทรัพย์สินของผู้กล่าวหา รายละเอียดปรากฏตามบัญชีทรัพย์ถูกประทุษร้ายในคดีนี้ ไว้ในที่เกิดเหตุ แล้วได้ออกจากที่เกิดเหตุไปเพื่อไปทำธุระ ภายหลังผู้กล่าวหาได้กลับเข้ามายังที่เกิดเหตุอีกครั้ง ปรากฏว่ารถคันดังกล่าวได้หายไป ผู้กล่าวหาได้ติดตามและสอบถามไปยังที่ต่างๆแล้ว ไม่มีผู้ใดทราบเหตุ จึงเชื่อว่าจะต้องมีคนร้ายมาลักเอาไป ผู้กล่าวหาจึงได้มาแจ้งความร้องทุกข์ ต่อพนักงานสอบสวน ให้สืบสวนหาทรัพย์ที่หายไป และติดตามตัวคนร้ายมาดำเนินคดีต่อไป'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	25	,	'ลักทรัพย์(กระเป๋าใส่เงิน)ในอำเภอ'	,	'ตามวันเวลาที่เกิดเหตุผู้เสียหายได้ไปยังอำเภอที่เกิดเหตุ เพื่อไปทำบัตรประจำตัวประชาชน ซึ่งขณะรอทำบัตรได้วางกระเป๋าสะพายภายในมีทรัพย์สินมีค่าหลายอย่างไว้ที่เก้าอี้นั่งข้างตัว ต่อมาเจ้าหน้าที่ได้เรียกไปทำบัตร จึงได้ลุกขึ้นไปทำบัตร โดยไม่ได้นำกระเป๋าดังกล่าวไปด้วย ภายหลังได้ทำบัตรแล้ว และจะกลับบ้าน เมื่อตรวจดูกระเป๋าดังกล่าวปรากฏว่าได้หายไป สอบถามผู้อยู่ข้างเคียงแล้วไม่มีผู้ใดทราบเหตุ เชื่อว่าจะต้องมีคนร้ายมาลักไป จึงได้มาแจ้งความร้องทุกข์ต่อพนักงานสอบสวนให้สืบสวนหาทรัพย์สินที่หายไป และนำตัวคนร้ายในคดีนี้มาดำเนินคดี ต่อมาเจ้าหน้าที่ตำรวจได้ไปตรวจค้นบ้านพักของผู้ต้องหา พบทรัพย์สินของผู้เสียหายที่ถูกประทุษร้ายไป จึงจับกุมนำส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ผู้ต้องหาได้ไปที่อำเภอที่เกิดเหตุ พบผู้เสียหายได้วางกระเป๋าสะพายไว้ที่เก้าอี้นั่งข้างตัว เมื่อผู้เสียหายลุกออกไปทำบัตรประจำตัว จึงได้แอบลักเอากระเป๋าดังกล่าว ซึ่งภายในมีทรัพย์สินปรากฏตามบัญชีทรัพย์ถูกประทุษร้ายในคดีนี้ แล้วหลบหนีไป ต่อมาได้มีเจ้าหน้าที่ตำรวจนำหมายค้นศาล มาตรวจค้นบ้านพักของผู้ต้องหา ผู้ต้องหารับเป็นเจ้าของบ้านและนำการตรวจค้น โดยก่อนการตรวจค้นเจ้าหน้าที่ได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูก่อนแล้ว ผลการตรวจค้นเจ้าหน้าที่ฯพบของกลางเป็นทรัพย์สินของผู้เสียหายที่ผู้ต้องหาได้ลักมา ปรากฏตามบัญชีของกลางในคดีนี้ เจ้าหน้าที่ฯจึงได้แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหารับทราบข้อกล่าวหาแล้วให้การรับสารภาพ จึงได้ถูกจับกุมนำส่งพนักงานสอบสวนดำเนินคดี พร้อมของกลางที่ผู้ต้องหาได้ลักมา โดยผู้ต้องหาไม่ขอโต้แย้งกรรมสิทธิ์ในทรัพย์สินของกลางแต่อย่างใด'	,	'ตามวันเวลาที่เกิดเหตุผู้กล่าวหาได้ไปยังอำเภอที่เกิดเหตุ เพื่อไปทำบัตรประจำตัวประชาชน โดยขณะรอทำบัตรได้วางกระเป๋าสะพายซึ่งภายในมีทรัพย์สินมีค่าหลายอย่างไว้ ปรากฏตามบัญชีประทุษร้ายในคดีนี้ ที่เก้าอี้นั่งข้างตัว ต่อมาเจ้าหน้าที่ได้เรียกไปทำบัตร จึงได้ลุกขึ้นไปทำบัตร ไม่ได้นำกระเป๋าดังกล่าวไปด้วย ภายหลังได้ทำบัตรแล้ว และจะกลับบ้าน เมื่อตรวจดูกระเป๋าดังกล่าวปรากฏว่าได้หายไป สอบถามผู้อยู่ข้างเคียงแล้วไม่มีผู้ใดทราบเหตุ เชื่อว่าจะต้องมีคนร้ายมาลักไป จึงได้มาแจ้งความร้องทุกข์ให้นำตัวผู้ต้องหานี้มาดำเนินคดีต่อไป'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	26	,	'ร่วมกันลักทรัพย์ ในเคหสถานในเวลากลางคืน โดยทำอันตรายสิ่งกีดกั้น หรือรับของโจร'	,	'ตามวันเวลาที่เกิดเหตุ ผู้เสียหายซึ่งเป็นผู้กล่าวหาในคดีนี้ ได้ปิดร้านค้า และได้กลับมาดูอีกครั้งหนึ่ง ปรากฏพบว่าประตูร้านถูกงัด จึงได้เข้าไปสำรวจดูทรัพย์สินในร้าน และพบว่าหายไปหลายรายการปรากฏตามบัญชีทรัพย์ถูกประทุษร้ายในคดีนี้ เชื่อว่าจะต้องมีคนร้ายงัดเข้าไปทางประตูดังกล่าวแล้ว ลักเอาทรัพย์สินภายในร้านแล้วหลบหนีไป ผู้เสียหายจึงได้มาแจ้งความร้องทุกข์ให้สืบสวนหาทรัพย์สินที่หายไป และนำคนร้ายมาดำเนินคดีต่อไป ต่อมาผู้เสียหายได้ทราบว่าเจ้าหน้าที่ตำรวจติดตามตัวผู้ต้องหาได้ พร้อมกับทรัพย์ที่หายไปบางรายการ ซึ่งผู้เสียหายจำได้ว่าเป็นของผู้เสียหาย ต่อมาผู้ต้องหาได้เข้ามอบตัวต่อพนักงานสอบสวนจึงรับตัวไว้ดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ผู้ต้องหาที่ ๑และ ผู้ต้องหาที่ ๒ ได้เข้าไปในร้ายที่เกิดเหตุ และได้งัดประตู้ร้านให้เสียหาย จนเข้าไปในร้านทางประตูดังกล่าวได้ จากนั้นได้ลักเอาทรัพย์สินภายในร้าน ปรากฏตามบัญชีทรัพย์ถูกประทุษร้ายในคดีนี้ ออกจากร้านแล้วหลบหนีไป ต่อมาได้มีเจ้าหน้าที่ตำรวจติดตามมาพบผู้ต้องหา จึงรับว่าได้เข้าไปลักทรัพย์ของผู้เสียหายจริง และได้ร่วมกันพาไปเอาทรัพย์สินที่ลักไป ปรากฏตามบัญชีทรัพย์ของกลางในคดีนี้ ส่งมอบให้กับเจ้าหน้าที่ฯ จึงได้ถูกจับกุมส่งพนักงานสอบสวนดำเนินคดี ชั้นจับกุมผู้ต้องหาให้การรับสารภาพ และไม่ขอโต้แย้งในทรัพย์สินของกลางแต่อย่างใด'	,	'ตามวันเวลาที่เกิดเหตุ กล่าวหาซึ่งเป็นผู้กล่าวหาในคดีนี้ ได้ปิดร้านค้า และได้กลับมาดูอีกครั้งหนึ่ง ปรากฏพบว่าประตูร้านถูกงัด จึงได้เข้าไปสำรวจดูทรัพย์สินในร้าน และพบว่าหายไปหลายรายการปรากฏตามบัญชีทรัพย์ถูกประทุษร้ายในคดีนี้ เชื่อว่าจะต้องมีคนร้ายงัดเข้าไปทางประตูดังกล่าวแล้ว ลักเอาทรัพย์สินภายในร้านแล้วหลบหนีไป ผู้กล่าวหาจึงได้มาแจ้งความร้องทุกข์ให้สืบสวนหาทรัพย์สินที่หายไป และนำคนร้ายมาดำเนินคดีต่อไป ต่อมาผู้เสียหายได้ทราบว่าเจ้าหน้าที่ตำรวจติดตามตัวผู้ต้องหาได้ พร้อมกับทรัพย์ที่หายไปบางรายการ ซึ่งผู้กล่าวหาจำได้ว่าเป็นของผู้เสียหายที่หายไป และได้รับทรัพย์สินดังกล่าวกลับคืนไปแล้ว'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	27	,	'ลักทรัพย์รถจักรยานยนต์จอดไว้ในสถานที่ราชการ ไม่รู้ตัว'	,	'ตามวันเวลาที่เกิดเหตุผู้เสียหายได้นำรถจักรยานยนต์ซึ่งเป็นของผู้เสียหาย รายละเอียดปรากฏตามบัญชีทรัพย์ถูกประทุษร้ายในคดีนี้ ไปจอดไว้ในสถานที่เกิดเหตุในคดีนี้ซึ่งเป็นสถานที่ราชการ จากนั้นได้เข้าไปทำธุระในสถานที่ดังกล่าว ครั้นกลับออกมาไม่พบรถจักรยานยนต์ที่ได้จอดไว้ เชื่อว่าจะต้องมีคนร้ายมาลักไป จึงได้มาแจ้งความร้องทุกข์ต่อพนักงานสอบสวน ให้สืบสวนหารถจักรยานยนต์ที่หายไป และติดตามตัวคนร้ายมาดำเนินคดีต่อไป'	,	''	,	'ตามวันเวลาที่เกิดเหตุผู้กล่าวหาได้นำรถจักรยานยนต์ซึ่งเป็นของผู้กล่าวหา รายละเอียดปรากฏตามบัญชีทรัพย์ถูกประทุษร้ายในคดีนี้ ไปจอดไว้ในสถานที่เกิดเหตุในคดีนี้ซึ่งเป็นสถานที่ราชการ จากนั้นได้เข้าไปทำธุระในสถานที่ดังกล่าว ครั้นกลับออกมาไม่พบรถจักรยานยนต์ที่ได้จอดไว้ เชื่อว่าจะต้องมีคนร้ายมาลักไป ผู้กล่าวหาจึงได้มาแจ้งความร้องทุกข์ต่อพนักงานสอบสวน ให้สืบสวนหารถจักรยานยนต์ที่หายไป และติดตามตัวคนร้ายมาดำเนินคดีต่อไป'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	28	,	'ลักทรัพย์ในเคหสถาน ถูกจับได้ในคดีอื่นรับว่าทำความผิดในคดีนี้'	,	'ก่อนเกิดเหตุในคดีนี้ ผู้เสียหายได้รับเหมาซ่อมแซมบ้านที่เกิดเหตุในคดีนี้ ได้นำเครื่องมือช่างต่างๆ หลายรายการไปไว้ในบ้านดังกล่าวตลอดมา ต่อมาตามวันเวลาที่เกิดเหตุภายหลังจากเลิกงานซ่อมแซมบ้าน ผู้เสียหายได้กลับไปพักผ่อนยังบ้านพักของผู้เสียหาย และได้กลับไปทำงานยังที่เกิดเหตุอีกครั้ง พบว่าทรัพย์สินดังกล่าวมาได้หายไป เชื่อว่าจะต้องมีคนร้ายเข้ามาลักไป ต่อมาผู้เสียหายได้ทราบว่าผู้ต้องหาในคดีนี้ถูกจับกุมตัวได้ในคดีอื่นพร้อมด้วยของกลางที่ลักมาหลายรายการ จึงได้ติดตามไปดูทรัพย์สินดังกล่าวที่สถานีตำรวจ พบว่ามีทรัพย์สินของผู้เสียหายที่ถูกลักมารวมอยู่ด้วย ผู้เสียหายได้สอบถามผู้ต้องหาให้การรับว่า ตามวันเวลาที่เกิดเหตุได้เข้าไปลักทรัพย์ของผู้เสียหายจริง ผู้เสียหายจึงได้แจ้งความร้องทุกข์ต่อพนักงานสอบสวนให้ดำเนินคดีกับผู้ต้องหานี้ต่อไป ผู้เสียหายได้ทรัพย์สินของผู้เสียหายคืนหมดแล้วโดยที่ผู้ต้องหาไม่โต้แย้งกรรมสิทธิ์ในทรัพย์ทรัพย์สินดังกล่าวแต่อย่างใด'	,	'ตามวันเวลาที่เกิดเหตุ ผู้ต้องหาได้เดินผ่านที่เกิดเหตุ เห็นประตูหลังบ้านที่เกิดเหตุเปิดอยู่และไม่มีผู้ใดอยู่ภายในบ้าน จึงมีความคิดที่จะลักทรัพย์ภายในบ้านดังกล่าวเพื่อนำมาใช้ประโยชน์ส่วนตน จึงได้เข้าไปในบ้านโดยผ่านประตูดังกล่าว พบทรัพย์สินต่างๆ หลายรายการ ซึ่งภายหลังเจ้าหน้าที่ตำรวจชุดตรวจยึดได้ยึดไว้เป็นของกลางในคดีนี้อยู่ในบ้าน จึงได้ลักเอาทรัพย์สินดังกล่าวไปเก็บไว้ที่บ้านพักของผู้ต้องหา ต่อมาผู้ต้องหาได้ไปกระทำความผิดอีกคดีหนึ่งและถูกเจ้าหน้าที่ตำรวจจับกุมตัวได้ จึงได้ยอมรับกับเจ้าหน้าที่ฯว่าได้ไปลักทรัพย์ของผู้เสียหายในคดีนี้ดังกล่าวมาด้วย จึงได้นำเจ้าหน้าที่ฯไปยึดทรัพย์สินดังกล่าวมาเป็นของกลาง ต่อมาได้มีผู้เสียหายในคดีนี้ได้เขามาสอบถามผู้ต้องหาถึงทรัพย์สินที่หายไป ผู้ต้องหาให้การรับว่าได้ไปลักทรัพย์สินดังกล่าวของผู้เสียหายจริง จึงได้ถูกผู้เสียหายแจ้งความดำเนินคดีกับผู้ต้องหา ผู้ต้องหาไม่ขอโต้แย้งในกรรมสิทธิ์ในทรัพย์ของกลางที่ลักมาแต่อย่างใด'	,	'ก่อนเกิดเหตุในคดีนี้ ผู้กล่าวหาได้รับเหมาซ่อมแซมบ้านผู้อื่นซึ่งเป็นที่เกิดเหตุในคดีนี้ ได้นำเครื่องมือช่างต่างๆ หลายรายการ รายละเอียดปรากฏตามบัญชีทรัพย์ถูกประทุษร้ายในคดีนี้ ไปไว้ในบ้านดังกล่าวตลอดมา ต่อมาตามวันเวลาที่เกิดเหตุภายหลังจากเลิกงานซ่อมแซมบ้านในวันนั้น ผู้กล่าวหาได้กลับไปยังบ้านพักของผู้กล่าวหาเพื่อพักผ่อน จนกระทั่งวันรุ่งขึ้นผู้กล่าวหาได้กลับไปทำงานยังที่เกิดเหตุอีกครั้ง พบว่าทรัพย์สินดังกล่าวมาได้หายไป สอบถามชาวบ้านข้างเคียงไม่มีผู้ใดทราบเหตุ จึงเชื่อว่าจะต้องมีคนร้ายเข้ามาลักไป โดยเข้ามาทางประตูด้านหลังบ้านซึ่งถูกเปิดทิ้งไว้ แล้วคนร้ายได้ลักเอาทรัพย์ดังกล่าวหลบหนีไป ต่อมาในวันที่ผู้กล่าวหาได้มาแจ้งความร้องทุกข์นี้ ผู้กล่าวหาทราบว่าผู้ต้องหาในคดีนี้ถูกจับกุมตัวได้ในคดีอื่นพร้อมด้วยของกลางที่ลักมาหลายรายการ ผู้กล่าวหาจึงได้ติดตามไปดูทรัพย์สินดังกล่าวที่สถานีตำรวจ พบว่ามีทรัพย์สินของผู้กล่าวหาที่ถูกลักมาดังที่ให้การมาแล้วรวมอยู่ด้วย ผู้กล่าวหาจึงได้สอบถามผู้ต้องหาให้การรับกับผู้กล่าวหาว่า ตามวันเวลาที่เกิดเหตุได้เข้าไปลักทรัพย์ของผู้กล่าวหาในที่เกิดเหตุจริง ผู้กล่าวหาจึงได้แจ้งความร้องทุกข์ต่อพนักงานสอบสวนให้ดำเนินคดีกับผู้ต้องหานี้ต่อไป ผู้กล่าวหาได้ทรัพย์สินของผู้กล่าวหาคืนหมดแล้วโดยที่ผู้ต้องหาไม่โต้แย้งกรรมสิทธิ์ในทรัพย์ทรัพย์สินนั้นแต่อย่างใด'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	29	,	'เสพยาบ้า ตั้งจุดตรวจจุดสกัด พบผู้ต้องหาขับขี่รถไม่มีใบขับขี่ มีและเสพยาบ้า'	,	'ก่อนเกิดเหตุ เจ้าหน้าที่ชุดจับกุมได้ตั้งจุดตรวจจุดสกัดตามหน้าที่ ต่อมาตามวันเวลาที่เกิดเหตุพบผู้ต้องหาขับขี่รถยนต์ผ่านมาในที่เกิดเหตุมีลักษณะพิรุธ จึงได้เรียกให้หยุดเพื่อตรวจสอบและตรวจค้น ผลการตรวจสอบพบผู้ต้องหาไม่มีใบอนุญาตให้ขับขี่รถยนต์ ตรวจค้นพบยาเสพติดให้โทษ(เมทแอมเฟตามีน) อยู่ในความครอบครองโดยที่ผู้ต้องหาซึ่งไม่ได้รับอนุญาตให้มีไว้ในครอบครอง จึงยึดไว้เป็นของกลาง นำตัวผู้ต้องหาไปตรวจปัสสาวะ พบสารเสพติดให้โทษในปัสสาวะ(เมทแอมเฟตามีน) จึงแจ้งข้อกล่าวหาให้ทราบ แล้วจับกุมผู้ต้องหา นำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหาขับขี่รถยนต์ผ่านมายังที่เกิดเหตุโดยไม่มีใบอนุญาตให้ขับขี่รถ ได้มีเจ้าหน้าที่ชุดจับกุม ทราบชื่อภายหลังปรากฏตามบันทึกการจับกุมในคดีนี้ ได้เข้ามาแสดงตนเป็นเจ้าหน้าที่ตำรวจ ขอตรวจค้นผู้ต้องหา ซึ่งผู้ต้องหายินยอมให้ตรวจค้นแต่โดยดี โดยก่อนจะลงมือตรวจค้น เจ้าหน้าที่ได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูจนเป็นที่พอใจก่อนแล้ว ผลการตรวจค้นเจ้าหน้าที่พบยาเสพติดให้โทษ(เมทแอมเฟตามีน) อยู่ในความครอบครองของผู้ต้องหา ซึ่งยาเสพติดให้โทษดังกล่าวเป็นของผู้ต้องหา มีไว้ในครอบครองโดยไม่ได้รับอนุญาต เจ้าหน้าที่จึงได้ยึดไว้เป็นของกลาง และขอตรวจปัสสาวะของผู้ต้องหา โดยที่ผู้ต้องหายินยอม ผลการตรวจปัสสาวะพบสารเสพติดให้โทษ(เมทแอมเฟตามีน)ในปัสสาวะ เนื่องจากก่อนที่จะถูกจับกุมเล็กน้อยผู้ต้องหาได้เสพยาเสพติดให้โทษ(เมทแอมเฟตามี) มาก่อนในปริมาณ ๑ เม็ด โดยการเผาไฟแล้วสูดดมเอากลิ่นไอ โดยเสพในตำบลที่เกิดเหตุ เจ้าหน้าที่จึงได้แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงได้ถูกจับกุม นำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้กล่าวหากับพวกซึ่งมีรายชื่อตามบันทึกการจับกุมในคดีนี้ ได้ตั้งจุดตรวจจุดสกัดในที่เกิดเหตุในคดีนี้ตามหน้าที่ พบผู้ต้องหาขับขี่รถยนต์ผ่านมาในที่เกิดเหตุมีลักษณะเป็นพิรุธ จึงได้เรียกให้หยุดเพื่อขอตรวจสอบและตรวจค้น โดยก่อนที่ผู้กล่าวหากับพวกจะลงมือตรวจสอบหรือตรวจค้น ได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูจนเป็นที่พอใจก่อนแล้ว ผลการตรวจสอบพบผู้ต้องหาไม่มีใบอนุญาตให้ขับขี่รถ ตรวจค้นพบยาเสพติดให้โทษ(เมทแอมเฟตามีน) อยู่ในความครอบครองของผู้ต้องหาโดยที่ผู้ต้องหาไม่ได้รับอนุญาตให้มีไว้ในครอบครอง จึงยึดไว้เป็นของกลาง รายละเอียดปรากฏตามบัญชีของกลางในคดีนี้ จากนั้นได้นำตัวผู้ต้องหาไปตรวจปัสสาวะโดยที่ผู้ต้องหายินยอม พบสารเสพติดให้โทษ(เมทแอมเฟตามีน)ในปัสสาวะของผู้ต้องหา ซึ่งเชื่อว่าผู้ต้องหาได้เสพยาเสพติดให้โทษมาดังกล่าวก่อน จึงแจ้งข้อกล่าวหาให้ทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงจับกุมผู้ต้องหา นำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	30	,	'มีและเสพยาบ้า ผู้ต้องหาโดยสารรถยนต์คนอื่นมา'	,	'เจ้าหน้าที่ชุดจับกุม ได้ตั้งจุดตรวจจุดสกัดในที่เกิดเหตุ พบผู้ต้องหาโดยสารรถยนต์ของผู้อื่นมา มีลักษณะคล้ายคนติดยาเสพติด จึงได้ขอตรวจค้น ผลการตรวจค้นพบยาเสพติดให้โทษ(เมทแอมเฟตามีน) อยู่ในครอบครองของผู้ต้องหา ซึ่งผู้ต้องหาไม่ได้รับอนุญาตให้มีไว้ในครอบครอง จึงยึดไว้เป็นของกลาง จากนั้นได้นำตัวไปตรวจปัสสาวะเบื้องต้น พบเมทแอมเฟตามีนในปัสสาวะ เชื่อว่าผู้ต้องหาได้เสพยาบ้าโดยฝ่าฝืนกฎหมาย จึงจับกุมผู้ต้องหานำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหาโดยสารรถยนต์ของผู้อื่นมาผ่านมาในที่เกิดเหตุ ได้มีเจ้าหน้าที่ชุดจับกุม ภายหลังทราบชื่อปรากฏรายชื่อตามบันทึกการจับกุมในคดีนี้ ได้เข้ามาแสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้นผู้ต้องหา ซึ่งเจ้าหน้าที่ดังกล่าวได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูก่อนแล้ว ผลการตรวจค้นพบยาเสพติดให้โทษ(เมทแอมเฟตามีน) อยู่ในครอบครองของผู้ต้องหา ซึ่งผู้ต้องหาไม่ได้รับอนุญาตให้มีไว้ในครอบครอง จึงยึดไว้เป็นของกลางรายละเอียดปรากฏตามบัญชีของกลางในคดีนี้ และผู้ต้องหารับว่าเป็นผู้เสพยาเสพติดให้โทษ(เมทแอมเฟตามีน) เจ้าหน้าที่จึงนำผู้ต้องหาไปตรวจปัสสาวะ ผลการตรวจปัสสาวะ พบเมทแอมเฟตามีนในปัสสาวะของผู้ต้องหา เนื่องจากผู้ต้องหาได้เสพยาเสพติดให้โทษ(เมทแอมเฟตามีนมา)ก่อน โดยเสพครั้งสุดท้ายในวันก่อนถูกจับกุม เมื่อเวลาประมาณ ๑๐.๐๐ น. ในตำบลที่เกิดเหตุ ในปริมาณ ๑ เม็ด โดยวิธีเผายาบ้าในกระดาษฟรอยด์แล้วสูดดมเอากลิ่นไอ เจ้าหน้าที่ได้แจ้งข้อกล่าวหาให้ทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงถูกจับกุมนำผู้ต้องหาและของกลาง ส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหาและพวกปรากฏรายชื่อตามบันทึกการจับกุมในคดีนี้ ได้ตั้งจุดตรวจจุดสกัดในที่เกิดเหตุ พบผู้ต้องหาโดยสารรถยนต์ของผู้อื่นมา มีลักษณะคล้ายคนติดยาเสพติด จึงได้แสดงตนเป็นเจ้าหน้าที่ขอตรวจค้นผู้ต้องหา ซึ่งผู้กล่าวหากับพวกได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูก่อนแล้ว ผลการตรวจค้นพบยาเสพติดให้โทษ(เมทแอมเฟตามีน) อยู่ในครอบครองของผู้ต้องหา ซึ่งผู้ต้องหาไม่ได้รับอนุญาตให้มีไว้ในครอบครอง จึงยึดไว้เป็นของกลางรายละเอียดปรากฏตามบัญชีของกลางในคดีนี้ จากนั้นได้นำผู้ต้องหาไปตรวจปัสสาวะเบื้องต้นโดยที่ผู้ต้องหายินยอม ซึ่งผลการตรวจปัสสาวะ พบสารเสพติดให้โทษ(เมทแอมเฟตามีน)ในปัสสาวะของผู้ต้องหา เชื่อว่าผู้ต้องหาได้เสพยาบ้าจริง จึงแจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพ จึงจับกุมผู้ต้องหานำผู้ต้องหาและของกลาง ส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	31	,	'ป่าไม้ร่วมกับทหารค้นบ้านพักของผู้ต้องหา ไม่มีหมายค้นพบสิ่งของผิดกฎหมาย'	,	'เจ้าหน้าที่ชุดจับกุมประกอบด้วยเจ้าหน้าที่ป่าไม้และเจ้าหน้าที่ทหาร ได้ร่วมกันตรวจค้นบ้านพักของผู้ต้องหาซึ่งเป็นที่เกิดเหตุในคดีนี้ พบผู้ต้องหามีสิ่งของผิดกฎหมายอยู่ในครอบครอง รายละเอียดปรากฏตามบัญชีทรัพย์ของกลางในคดีนี้ จึงยึดไว้เป็นของกลาง จับกุมผู้ต้องหา นำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหาอยู่ที่บ้านพักของผู้ต้องหา ได้มีเจ้าหน้าที่ชุดจับกุม ทราบชื่อภายหลังปรากฏตามบันทึกการจับกุมในคดีนี้ ได้มาแสดงตนเป็นเจ้าหน้าที่ขอตรวจค้นบ้านพักของผู้ต้องหา ผู้ต้องหาได้แสดงตนเป็นเจ้าของบ้าน ยินยอมให้เจ้าหน้าที่ทำการตรวจค้นโดยผู้ต้องหาเป็นผู้นำทำการตรวจค้น ซึ่งก่อนที่เจ้าหน้าที่จะลงมือตรวจค้น ได้แสดงความบริสุทธิ์ใจจนเป็นที่พอใจแก่ผู้ต้องหาแล้ว ผลการตรวจค้นเจ้าหน้าที่พบสิ่งของผิดกฎหมาย ซึ่งเป็นของผู้ต้องหามีไว้ในครอบครองโดยไม่ได้รับอนุญาต รายละเอียดตามบัญชีของกลางในคดีนี้ เจ้าหน้าที่จึงได้แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงได้ถูกจับกุมนำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหากับพวกประกอบด้วยเจ้าหน้าที่ทหารและเจ้าหน้าที่ป่าไม้ ได้ไปทำการตรวจค้นบ้านพักของผู้ต้องหา ซึ่งเป็นที่เกิดเหตุในคดีนี้ เนื่องจากสืบทราบว่ามีสิ่งของผิดกฎหมายซุกซ่อนอยู่ พบผู้ต้องหาอยู่ภายในบ้านและแสดงตนเป็นเจ้าของบ้าน จึงได้แสดงตนเป็นเจ้าหน้าที่ขอทำการตรวจค้น ซึ่งผู้ต้องหายินยอมให้ตรวจค้นและเป็นผู้นำทำการตรวจค้น โดยก่อนผู้กล่าวหากับพวกจะลงมือตรวจค้น ได้แสดงความบริสุทธิ์ใจจนเป็นที่พอใจแก่ผู้ต้องหาแล้ว ผลการตรวจค้นผู้กล่าวหากับพวกพบสิ่งของผิดกฎหมาย รายละเอียดปรากฏตามบัญชีทรัพย์ของกลางในคดีนี้ อยู่ในความครอบครองของผู้ต้องหา ซึ่งผู้ต้องหารับว่าเป็นของผู้ต้องหาและมีไว้ในครอบครองโดยไม่ได้รับอนุญาต จึงได้ยึดไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพ จึงได้จับกุมนำผู้ต้องหาและของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	32	,	'เจ้าหน้าที่ป่าไม้ออกตรวจพบพื้นที่ป่าสงวนถูกบุกรุก และมีการทำไม้กระยาเลย ยึดไม้กระยาเลยเป็นของกลาง ไม่รู้ตัว'	,	'ตามวันเวลาที่เกิดเหตุเจ้าหน้าที่ป่าไม้ ได้ร่วมกันออกตรวจที่เกิดเหตุ พบพื้นที่ป่าสวนแห่งชาติ ถูกบุกรุก แถวถาง และพบไม้หวงห้าม(กระยาเลย) ถูกตัดโค่นจำนวนมาก เพื่อยึดถือครอบครองป่าและไม้ห้วงห้ามดังกล่าว อันเป็นการกระทำที่ไม่ชอบด้วยกฎหมาย จึงได้มาแจ้งความร้องทุกข์ต่อพนักงานสอบสวนให้สืบสวนหาตัวผู้กระทำความผิดมาดำเนินคดีตามกฎหมายต่อไป'	,	''	,	'ตามวันเวลาที่เกิดเหตุเจ้าหน้าที่ป่าไม้ปรากฏชื่อตามบันทึกการตรวจยึดในคดีนี้ ได้ร่วมกันออกตรวจที่เกิดเหตุ พบพื้นที่ป่าสวนแห่งชาติถูกบุกรุก แผ้วถาง ตัดฟันต้นไม้ต่างๆ รวมทั้งต้นไม้หวงห้าม(ไม้กระยาเลย) เป็นบริเวณกว้าง ซึ่งเป็นการบุกรุก แผ้วถางใหม่ จึงเชื่อว่ามีคนร้ายได้ทำการดังกล่าว เพื่อยึดถือครอบครองไม้หวงห้ามและครอบครองที่เกิดเหตุ โดยพื้นที่ดังกล่าวรัฐไม่ได้อนุญาตให้ผู้หนึ่งผู้ใดเข้าไปทำประโยชน์แต่อย่างหนึ่งอย่างใด ผู้กล่าวหากับพวกเป็นว่าเป็นการกระทำที่ไม่ชอบด้วยกฎหมาย จึงได้ร่วมกันตรวจสอบพื้นที่ที่มีการบุกรุก และยึดไม้ห้วงห้ามดังกล่าวไว้เป็นของกลาง รายละเอียดปรากฏตามบัญชีทรัพย์ของกลางในคดีนี้ แล้วมาแจ้งความร้องทุกข์ต่อพนักงานสอบสวน ให้สืบสวนหาตัวผู้กระทำความผิดมาดำเนินคดีตามกฎหมายต่อไป ขณะเข้าไปตรวจพื้นที่ ไม่พบผู้หนึ่งผู้ใดในที่เกิดเหตุหรือบริเวณใกล้เคียง และไม่สงสัยว่าผู้หนึ่งผู้ใดจะเป็นคนร้ายในคดีนี้'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	33	,	'ออกตรวจที่เกิดเหตุ พบผู้ต้องหามียาบ้าในครอบครอง'	,	'เจ้าหน้าที่ชุดจับกุม ออกตรวจที่เกิดเหตุ พบผู้ต้องหามีของกลางยาบ้า ผิดกฎหมายในครอบครอง จึงยึดเป็นของกลาง จับกุมผู้ต้องหาพร้อมนำของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหากำลังยืนอยู่ในที่เกิดเหตุ ได้มีเจ้าหน้าที่ทราบชื่อภายหลังปรากฏตามบันทึกการจับกุมในคดีนี้ เข้ามาแสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้น ซึ่งผู้ต้องหายินยอมให้ตรวจค้นแต่โดยดี และก่อนตรวจค้นได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูจนเป็นที่พอใจแล้ว ผลการตรวจค้นเจ้าหน้าที่ฯพบของกลางผิดกฎหมาย ยาบ้า อยู่ในความครอบครองของผู้ต้องหา รายละเอียดปรากฏตามบัญชีของกลางในคดีนี้ เจ้าหน้าที่ชุดจับกุมจึงได้ยึดไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหารับทราบข้อกล่าวหาแล้ว ให้การรับสารภาพตลอดข้อกล่าวหา จึงถูกจับกุม เจ้าหน้าที่ชุดจับกุมได้นำผู้ต้องหาและของกลาง ส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหากับพวก ปรากฏรายชื่อตามบันทึกการจับกุมในคดีนี้ ได้ออกตรวจรักษาความสงบเรียบร้อยตามหน้าที่ เมื่อมาถึงที่เกิดเหตุพบผู้ต้องหายืนอยู่ในที่เกิดเหตุมีท่าทางเป็นพิรุธคล้ายผู้ติดยาเสพติด จึงได้แสดงตนเป็นเจ้าหน้าที่ตำรวจและขอตรวจค้นผู้ต้องหา โดยก่อนการตรวจค้นได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูจนเป็นที่พอใจก่อนแล้ว ผลการตรวจค้นพบผู้ต้องหามีของกลางยาบ้ารายละเอียดปรากฏตามบัญชีของกลางในคดีนี้ จึงได้สอบถามผู้ต้องหาถึงยาบ้าดังกล่าว ผู้ต้องหารับว่าเป็นผู้ต้องหามีไว้ในครอบครองโดยไม่ได้รับอนุญาต ผู้กล่าวหากับพวกจึงได้ยึดไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหารับทราบข้อกล่าวหาแล้ว ให้การรับสารภาพตลอดข้อกล่าวหา จึงจับกุมผู้ต้องหา พร้อมนำของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	34	,	'จับต่างด้าวขณะทำงาน อยู่ในราชอาณาจักรโดยใบอนุญาตสิ้นสุดและทำงานโดยไม่มีใบอนุญาต'	,	'เจ้าพนักงานชุดจับกุม ได้ร่วมกันออกตรวจพื้นที่ที่เกิดเหตุ เมื่อไปถึงที่เกิดเหตุ พบผู้ต้องหา กำลังทำงานเป็นกรรมกรก่อสร้าง ผลการตรวจสอบพบว่าผู้ต้องหาไม่มีสัญชาติไทย อยู่ในราชอาณาจักรโดยการอนุญาตสิ้นสุด และไม่มีใบอนุญาตให้ทำงาน จึงได้แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าว จึงได้จับกุมตัวนำส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหากำลังรับจ้างทำงานก่อสร้างอยู่ในที่เกิดเหตุ ได้มีเจ้าหน้าที่ชุดจับกุมปรากฏตามบันทึกการจับกุมในคดีนี้ ได้เข้ามาทำการตรวจสอบ พบว่าผู้ต้องหาเป็นบุคคลต่างด้าวมีบัตรประจำตัวคนซึ่งไม่มีสัญชาติไทย ได้รับอนุญาตให้ทำงานประเภทกรรมกร(เกษตรและปศุสัตว์) แต่การอนุญาตให้ทำงานได้สิ้นสุดลงแล้ว แต่ได้มาทำงานก่อสร้างดังกล่าว เจ้าหน้าที่ชุดจับกุม จึงได้แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าว จึงได้ถูกจับกุมตัวส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุผู้กล่าวหากับพวกซึ่งเป็นเจ้าพนักงานตำรวจ และพนักงานเจ้าหน้าที่ ตามพระราชกำหนดการบริหารการจัดการการทำงานของคนต่างด้าว ปรากฏรายชื่อตามบันทึกการจับกุมในคดีนี้ ได้ร่วมกันออกตรวจพื้นที่ที่เกิดเหตุ เนื่องจากได้รับแจ้งว่ามีบุคคลต่างด้าวเข้าไปทำงานโดยไม่ได้รับอนุญาตจากพนักงานเจ้าหน้าที่ เมื่อไปถึงที่เกิดเหตุ พบผู้ต้องหา กำลังทำงานเป็นกรรมกรก่อสร้าง ผลการตรวจสอบพบว่าผู้ต้องหาไม่มีสัญชาติไทย อยู่ในราชอาณาจักรโดยการอนุญาตสิ้นสุด และไม่มีใบอนุญาตให้ทำงาน จึงได้แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าว จึงได้จับกุมตัวนำส่งพนักงานสอบสวนดำเนินคดีต่อไป'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	35	,	'เปิดร้านมินิมทร์ท เอายาแก้ไอมาขาย ยายยาอันตราย'	,	'ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหาได้พร้อมกับพวกไปยังร้านที่เกิดเหตุ พบผู้ต้องหาอยู่ในร้านที่เกิดเหตุแสดงตนเป็นเจ้าของร้าน ตรวจสอบภายในร้านพบยาแก้ไอชนิดน้ำเชื่อม วางอยู่บนชั้นสำหรับวางสินค้าจำหน่าย มีส่วนผสมของยาอันตราย สอบถามผู้ต้องหาให้การรับว่าได้ซื้อยาดังกล่าวมาเพื่อจำหน่ายโดยไม่ได้รับอนุญาต จึงได้ยึดยาดังกล่าวไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงได้จับกุมผู้ต้องหานำผู้ต้องหายาของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ผู้ต้องหาเป็นเจ้าของร้านค้ามินิมาร์ทที่เกิดเหตุ เปิดกิจการขายสินค้าทั่วไปมานานแล้ว ต่อมาตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหาเปิดร้านดังกล่าวเพื่อขายสินค้า ได้มีเจ้าหน้าที่ชุดจับกุม มีรายชื่อปรากฏตามบันทึกการจับกุมในคดีนี้ ได้เข้ามาตรวจสอบสินค้าภายในร้านที่ผู้ต้องหานำเข้ามาจำหน่าย โดยที่ผู้ต้องหายินยอมให้เจ้าหน้าที่ดังกล่าวทำการตรวจสอบ ผลการตรวจสอบเจ้าหน้าที่พบยาแก้ไอชนิดน้ำเชื่อม ซึ่งภายหลังเจ้าหน้าที่ได้ยึดไว้รายละเอียดปรากฏตามบัญชีของกลางในคดีนี้ อยู่บนชั้นสำหรับวางสินค้าจำหน่าย มีส่วนผสมของยาอันตราย ซึ่งผู้ต้องหาไม่มีใบอนุญาตให้จำหน่ายได้ โดยได้ยาดังกล่าวผู้ต้องหาเป็นผู้ซื้อไว้เพื่อนำออกจำหน่าย เจ้าหน้าที่จึงได้ยึดยาดังกล่าวไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงได้ถูกจับกุมผู้ต้องหานำผู้ต้องหายาของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	'ก่อนเกิดเหตุในคดีนี้ ผู้กล่าวหาได้รับแจ้งจากสายลับว่าร้านมินิมาร์ทที่เกิดเหตุ มีการจำหน่ายยาแก้ไอ ซึ่งเป็นยาอันตรายโดยไม่ได้รับอนุญาต จึงได้รายงานให้ผู้บังคับบัญชาทราบและได้สั่งการให้สืบสืบสวนจับกุม ต่อมาตามวันเวลาที่เกิดเหตุ ผู้กล่าวหาได้พร้อมกับพวกมีรายชื่อปรากฏตามบันทึกการจับกุมในคดีนี้ไปยังร้านที่เกิดเหตุ พบผู้ต้องหาอยู่ในร้านที่เกิดเหตุแสดงตนเป็นเจ้าของร้าน จึงได้ขอตรวจสอบภายในร้านพร้อมกับผู้ต้องหา โดยผู้ต้องหายินยอมให้ตรวจสอบ ผลการตรวจสอบพบยาแก้ไอชนิดน้ำเชื่อม รายละเอียดปรากฏตามบัญชีของกลางในคดีนี้ อยู่บนชั้นสำหรับวางสินค้าจำหน่าย มีส่วนผสมของไดเฟนไฮดรามีน ( Diphenhydramine) ซึ่งไดเฟนไฮดรามีน ( Diphenhydramine) เป็นยากลุ่ม Antihistamine จัดเป็นยาอันตราย ตามประกาศกระทรวงสาธารณสุข เรื่องยาอันตราย ข้อ ๓( ๓๒) ตาม พระราชบัญญัติยา พ.ศ. ๒๕๕๑๐ สอบถามผู้ต้องหาให้การรับว่าได้ซื้อยาดังกล่าวมาเพื่อเอาไว้จำหน่ายโดยไม่ได้รับอนุญาต จึงได้ยึดยาดังกล่าวไว้เป็นของกลาง แจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงได้จับกุมผู้ต้องหานำผู้ต้องหายาของกลางส่งพนักงานสอบสวนดำเนินคดี'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	36	,	'บริษัทฯหรือห้างหุ้นส่วนไม่ได้มีการดำเนินการยื่นงบการเงินดังกล่าวต่อพาณิชย์จังหวัด'	,	'ตามวันเวลาเกิดเหตุบริษัทฯผู้ต้องหา โดยหุ้นส่วนของบริษัทฯ ได้ขอจัดตั้งนิติบุคคลต่อพาณิชย์จังหวัด ต่อมาได้ดำเนินงานกิจการตามที่ได้ขอจัดตั้งไว้ หลังจากนั้นในช่วงเวลา ๑ - ๓๑ ธ.ค.ของทุกปีจะต้องมีการยื่นงบการเงินในรอบบัญชีต่อสำนักงานพาณิชย์ ภายในกำหนด ๑ เดือนนับแต่วันที่ประชุมใหญ่อนุมัติงบการเงินกรณีบริษัท จำกัด และภายในห้าเดือนนับแต่ปิดรอบปีทางบัญชีกรณีห้างหุ้นส่วนจำกัด ตามมาตรา ๑๑ วรรคหนึ่ง แห่งพระราชบัญญัติการบัญชี พ.ศ.๒๕๔๓ แต่ปรากฏว่าไม่ได้มีการดำเนินการ ผู้กล่าวหาจึงได้รับมอบหมายให้มาพบพนักงานสอบสวนแจ้งความร้องทุกข์ให้ดำเนินคดีกับบริษัทฯ และหุ้นส่วนของบริษัทฯต่อไป'	,	''	,	'ตามวันเวลาที่เกิดเหตุผู้ต้องหา ได้ขอจัดตั้งนิติบุคคลต่อพาณิชย์จังหวัด ต่อมาได้ดำเนินงานกิจการตามที่ได้ขอจัดตั้ง หลังจากดำเนินการมาแล้วนั้น จนกระทั่งในช่วงเวลา ๑ - ๓๑ ธ.ค.ของทุกปีจะต้องมีการยื่นงบการเงินในรอบบัญชีต่อสำนักงานพาณิชย์ จังหวัด ภายในกำหนด ๑ เดือนนับแต่วันที่ประชุมใหญ่อนุมัติงบการเงินกรณีบริษัท จำกัด และภายในห้าเดือนนับแต่ปิดรอบปีทางบัญชีกรณีห้างหุ้นส่วนจำกัด ตามมาตรา ๑๑ วรรคหนึ่ง แห่งพระราชบัญญัติการบัญชี พ.ศ.๒๕๔๓ จากการตรวจของผู้เสียหายพบว่ามีห้างหุ้นส่วนของผู้ต้องหา ไม่ได้มีการดำเนินการยื่นงบการเงินดังกล่าวต่อพาณิชย์จังหวัด ผู้กล่าวหาจึงได้รับมอบหมายให้มาพบพนักงานสอบสวนแจ้งความร้องทุกข์ให้ดำเนินคดีห้างหุ้นส่วน และผู้ต้องหาในคดีนี้ต่อไป'	,	''	);",
"	INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,AnswerSuspect,AnswerAccuser,ActionNote) values(	37	,	'มีวัตถุออกฤทธิ์ต่อจิตและประสาทประเภท 2 (คีตามีน) ไว้ในครอบครองโดยผิดกฎหมายและมียาเสพติดให้โทษประเภท 5 (กัญชา) ไว้ในครอบครองโดยไม่ได้รับอนุญาต'	,	'ตามวันเวลาที่เกิดเหตุ ผู้กล่าวหาและพวกปรากฏรายชื่อตามบันทึกการจับกุมในคดีนี้ ได้ออกปฏิบัติหน้าที่ป้องกันเหตุและรักษาความสงบเรียบร้อยทั่วไป เมื่อถึงที่เกิดเหตุ พบผู้ต้องหายืนสูบบุหรี่ มีท่าทางเป็นพิรุธคล้ายผู้ จึงได้แสดงตนเป็นเจ้าหน้าที่ขอตรวจค้นผู้ต้องหา ซึ่งผู้กล่าวหากับพวกได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูก่อนแล้ว ขณะที่ตรวจค้นมีแสงไฟนีออนจากเสาไฟส่องสว่างระยะ ๑๐ เมตร ผลการตรวจค้นพบด้านหน้าขวาของผู้ต้องหาจึงยึดไว้เป็นของกลาง ปรากฏรายละเอียดตามบัญชีของกลางในคดีนี้ จากนั้นได้นำผู้ต้องหาไปตรวจปัสสาวะเบื้องต้น ผลการตรวจปัสสาวะ พบว่ามีสารเสพติดในปัสสาวะ และได้สอบถามผู้ต้องหาแล้วรับว่ามีและได้เสพกัญชาโดยฝ่าฝืนกฎหมาย จึงแจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพ ส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ขณะที่ผู้ต้องหาอยู่ในที่เกิดเหตุ ได้มีเจ้าหน้าที่ชุดจับกุม ภายหลังทราบชื่อปรากฏรายชื่อตามบันทึกการจับกุมในคดีนี้ ได้เข้ามาแสดงตนเป็นเจ้าหน้าที่ตำรวจขอตรวจค้นผู้ต้องหา ซึ่งเจ้าหน้าที่ดังกล่าวได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูก่อนแล้ว ผลการตรวจค้น เจ้าหน้าที่พบกัญชาแห้งบรรจุอยู่ในซองพลาสติกใสอยู่ในซองบุหรี่ยี่ห้อ MAELBORO และพบสารคีตามีนบรรจุอยู่ในซองใสแบบมีซิปเปิดปิดด้านบน พับซ่อนอยู่ในลูกอม ยี่ห้อ Clorets สีเขียว ซุกซ่อนอยู่ในกระเป๋ากางเกงยีนต์สีดำด้านหน้าขวาของข้า ฯ จึงถูกยึดไว้เป็นของกลาง และ จึงได้แจ้งข้อกล่าวหาให้ทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพตลอดข้อกล่าวหา จึงถูกจับกุม พร้อมกับพบกัญชาแห้งบรรจุอยู่ในซองพลาสติกใส และพบสารคีตามีนบรรจุอยู่ในซองใสแบบมีซิปเปิดปิดด้านบน ส่งพนักงานสอบสวนดำเนินคดี'	,	'ตามวันเวลาที่เกิดเหตุ ข้าและพวกปรากฏรายชื่อตามบันทึกการจับกุมในคดีนี้ ได้ออกปฏิบัติหน้าที่ป้องกันเหตุและรักษาความสงบเรียบร้อยทั่วไป เมื่อถึงที่เกิดเหตุ พบผู้ต้องหายืนสูบบุหรี่ มีท่าทางเป็นพิรุธคล้ายผู้ติดยาเสพติด จึงได้แสดงตนเป็นเจ้าหน้าที่ขอตรวจค้นผู้ต้องหา ซึ่งผู้กล่าวหากับพวกได้แสดงความบริสุทธิ์ใจให้ผู้ต้องหาดูก่อนแล้ว ขณะที่ตรวจค้นมีแสงไฟนีออนจากเสาไฟส่องสว่างระยะ ๑๐ เมตร โดยมีผู้กล่าวหา เป็นผู้ตรวจค้น ผลการตรวจค้นพบพบกัญชาแห้งบรรจุอยู่ในซองพลาสติกใสอยู่ในซองบุหรี่ยี่ห้อ MAELBORO และพบสารคีตามีนบรรจุอยู่ในซองใสแบบมีซิปเปิดปิดด้านบน พับซ่อนอยู่ในลูกอม ยี่ห้อ Clorets สีเขียว ซุกซ่อนอยู่ในกระเป๋ากางเกงยีนต์สีดำด้านหน้าขวาของผู้ต้องหาจึงยึดไว้เป็นของกลาง ปรากฏรายละเอียดตามบัญชีของกลางในคดีนี้ จากนั้นได้นำผู้ต้องหาไปตรวจปัสสาวะเบื้องต้น ผลการตรวจปัสสาวะ พบว่ามีสารเสพติดในปัสสาวะ และได้สอบถามผู้ต้องหาแล้วรับว่ามีและได้เสพกัญชาโดยฝ่าฝืนกฎหมาย จึงแจ้งข้อกล่าวหาให้ผู้ต้องหาทราบ ผู้ต้องหาทราบข้อกล่าวหาแล้วให้การรับสารภาพ จึงจับกุมผู้ต้องหานำยาบ้าและตัวอย่างปัสสาวะของผู้ต้องหา ส่งพนักงานสอบสวนดำเนินคดี'	,	''	);"

                    };
//                                                "Insert into Tambon (NAME,AMPHURID,PROVINCEID,TAMBONID,ZIPCODE,LOC_CODE,DOPA_CODE) values ('บ่อกวางทอง','07','203','03','20270','03','20100300' );\n" +
//                                                "Insert into Tambon (NAME,AMPHURID,PROVINCEID,TAMBONID,ZIPCODE,LOC_CODE,DOPA_CODE) values ('ธาตุทอง','07','203','04','20270','04','20100400' );";
 
String [] insertCharge={
            "	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	1	,	'ก่นสร้าง แผ้วถางยึด ถือครอบครอง ป่า ในเขตสงวนแห่งชาติ และอุทยานแห่งชาติ'	,	'พระราชบัญญัติป่าสงวนแห่งชาติ พ.ศ. 2507 มาตรา 4, 6, 9, 14, 31, 35 พระราชบัญญัติป่าสงวนแห่งชาติ (ฉบับที่ 2) พ.ศ. 2522 มาตรา 9 พระราชบัญญัติป่าสงวนแห่งชาติ (ฉบับที่ 3) พ.ศ. 2528 มาตรา 4 พระราชบัญญัติอุทยานแห่งชาติ พ.ศ. 2504 มาตรา 4, 6, 16, 24, 29 พระราชบัญญัติป่าไม้ พ.ศ. 2484 มาตรา 4, 54, 72 ตรี, 74 ทวิ, 74 จัตวา พระราชบัญญัติป่าไม้ (ฉบับที่ 5) พ.ศ. 2518 มาตรา 22 พระราชบัญญัติป่าไม้ (ฉบับที่ 4) พ.ศ. 2503 มาตรา 8 พระราชบัญญัติป่าไม้ (ฉบับที่ 6) พ.ศ. 2522 มาตรา 7 กฎกระทรวง ฉบับที่ 471 (พ.ศ. 2515) ออกตามความในพระราชบัญญัติป่าสงวนแห่งชาติ พ.ศ. 2507'	,	'จำคุกไม่เกินห้าปี หรือปรับไม่เกินห้าหมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	2	,	'ข่มขืนใจเจ้าพนักงาน'	,	'ประมวลกฎหมายอาญา มาตรา 139 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 26) พ.ศ. 2560 มาตรา 4'	,	'จำคุกไม่เกินสี่ปี หรือปรับไม่เกินแปดหมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	3	,	'ให้สินบนเจ้าพนักงาน'	,	'ประมวลกฎหมายอาญา มาตรา 144 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 26) พ.ศ. 2560 มาตรา 4'	,	'จำคุกไม่เกินห้าปี หรือปรับไม่เกินหนึ่งแสนบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	4	,	'กระทำการอันควรขายหน้าต่อหน้าธารกำนัลโดยเปลือยหรือเปิดเผยร่างกาย หรือกระทำการลามกอย่างอื่น'	,	'ประมวลกฎหมายอาญา มาตรา 388 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 22) พ.ศ. 2558 มาตรา 6'	,	'ปรับไม่เกินห้าพันบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	5	,	'กระทำโดยประมาท เป็นเหตุให้ผู้อื่นรับอันตรายแก่กายหรือจิตใจ'	,	'ประมวลกฎหมายอาญา มาตรา 390 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 22) พ.ศ. 2558 มาตรา 6'	,	'จำคุกไม่เกินหนึ่งเดือนหรือปรับไม่เกินหนึ่งหมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	6	,	'กระทำโดยประมาทเป็นเหตุให้ผู้อื่นถึงแก่ความตาย'	,	'ประมวลกฎหมายอาญา มาตรา 291พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 26) พ.ศ. 2560 มาตรา 4'	,	'จำคุกไม่เกินสิบปี และปรับไม่เกินสองแสนบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	7	,	'กระทำโดยประมาทเป็นเหตุให้ผู้อื่นถึงแก่ความตาย และพกพาอาวุธปืนเข้าไปในสถานบริการ'	,	'พระราชบัญญัติอาวุธปืน เครื่องกระสุนปืน วัตถุระเบิด ดอกไม้เพลิง และสิ่งเทียมอาวุธปืน พ.ศ. 2490 มาตรา 4, 8 ทวิ, 72 ทวิ พระราชบัญญัติอาวุธปืน เครื่องกระสุนปืน วัตถุระเบิด ดอกไม้เพลิง และสิ่งเทียมอาวุธปืน (ฉบับที่ 3) พ.ศ. 2501 มาตรา 3 พระราชบัญญัติอาวุธปืน เครื่องกระสุนปืน วัตถุระเบิด ดอกไม้เพลิง และสิ่งเทียมอาวุธปืน (ฉบับที่ 7) พ.ศ. 2522 มาตรา 5, 7 คำสั่งของคณะปฏิรูปการปกครองแผ่นดิน ฉบับที่ 44 ลงวันที่ 21 ตุลาคาม 2519 ข้อ 3, 6, 7 พระราชบัญญัติสถานบริการ พ.ศ. 2509 มาตรา 16/2 พระราชบัญญัติสถานบริการ (ฉบับที่ 4) พ.ศ. 2546 มาตรา 9 ประมวลกฎหมายอาญา มาตรา 32, 91, 291, 371 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 26) พ.ศ. 2560 มาตรา 4'	,	'จำคุกไม่เกินสิบปี และปรับไม่เกินสองแสนบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	8	,	'แสดงตนเป็นเจ้าพนักงาน กระทำการเป็นเจ้าพนักงาน'	,	'ประมวลกฎหมายอาญา มาตรา 145 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 26) พ.ศ. 2560 มาตรา 4'	,	'จำคุกไม่เกินหนึ่งปี หรือปรับไม่เกินสองหมื่นบาทหรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	9	,	'กระทำอนาจารแก่เด็กอายุยังไม่เกินสิบห้าปี'	,	'ประมวลกฎหมาอาญา มาตรา 279 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 26) พ.ศ. 2560 มาตรา 11'	,	'จำคุกไม่เกินสิบปี หรือปรับไม่เกินสองแสนบาทหรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	10	,	'กระทําชําเราเด็กอายุยังไม่เกินสิบสามปี กระทำอนาจารแก่เด็กอายุยังไม่เกินสิบห้าปี'	,	'ประมวลกฎหมายอาญา มาตรา 277 วรรคสาม 279 วรรคสอง พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 8) พ.ศ. 2530 มาตรา 4 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 19) พ.ศ. 2550'	,	'จําคุกตั้งแต่เจ็ดปีถึงยี่สิบปี และปรับตั้งแต่หนึ่งแสนสี่หมื่นบาทถึงสี่แสนบาท หรือจําคุกตลอดชีวิต'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	11	,	'ขับรถโดยประมาท มีผู้ถึงแก่ความตาย'	,	'พระราชบัญญัติจราจรทางบก พ.ศ. 2522 มาตรา 43, 157 พระราชบัญญัติจราจรทางบก (ฉบับที่ 4) พ.ศ. 2535 มาตรา 27 ประมวลกฎหมายอาญา มาตรา 291 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 26) พ.ศ. 2560 มาตรา 4'	,	'จำคุกไม่เกินสิบปี และปรับไม่เกินสองแสนบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	12	,	'จำหน่ายยาเสพติดให้โทษประเภท 1 (ยาบ้า)'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 15, 66 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 3) พ.ศ. 2530 มาตรา 3 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 8, 19 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 6) พ.ศ. 2560 มาตรา 3 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 1 พ.ศ. 2561 ออกตามความในพระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 ลงวันที่ 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศกระทรวงสาธารณสุขฉบับดังกล่าว ลำดับที่ 38'	,	'จำคุกสิบห้าปี หรือจำคุกตลอดชีวิต หรือประหารชีวิต (ขึ้นอยู่กับปริมาณสารบริสุทธิ์)'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	13	,	'ผลิต และมียาเสพติดให้โทษประเภท 5 (กัญชา)'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 26/2, 75, 76, 100/1, 102 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4, 8 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 22 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 7) พ.ศ. 2562 มาตรา 9, 13, 17 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 5 พ.ศ. 2561 ออกตามความในพระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 ลงวันที่ 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศกระทรวงสาธารณสุขฉบับดังกล่าว ลำดับที่ 1 ประมวลกฎหมายอาญา มาตรา 32, 91 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 6) พ.ศ. 2526 มาตรา 4'	,	'จำคุกไม่เกินห้าปี และปรับไม่เกินห้าแสนบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	14	,	'มียาเสพติดให้โทษประเภท 1 (ยาบ้า) ไว้ในครอบครอง เสพและเป็นผู้ขับรถเสพยาเสพติดให้โทษประเภท 1 (เสพขับมียาบ้า)'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 57, 67, 91 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4, 8 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 3) พ.ศ. 2530 มาตรา 3 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 3, 6, 8, 19, 26 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 6) พ.ศ. 2560 มาตรา 67 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 1 พ.ศ. 2561 ลง 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศกระทรวงสาธารณสุขฉบับดังกล่าว ลำดับที่ 38 พระราชบัญญัติจราจรทางบก พ.ศ. 2522 มาตรา 4, 43 ทวิ, 157/1 พระราชบัญญัติจราจรทางบก (ฉบับที่ 6) พ.ศ. 2542 มาตรา 4 พระราชบัญญัติจราจรทางบก (ฉบับที่ 7) พ.ศ. 2550 มาตรา 9 ประมวลกฎหมายอาญา มาตรา 91 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 6) พ.ศ. 2526 มาตรา 4'	,	'จำคุกตั้งแต่หนึ่งปีถึงสิบปี หรือปรับตั้งแต่สองหมื่นบาทถึงสองแสนบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	15	,	'มียาเสพติดให้โทษประเภท 1 (ยาบ้า) ไว้ในครอบครอง และเสพติดให้โทษประเภท 1 (ยาบ้า)'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 15, 57, 67, 91 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 3) พ.ศ. 2530 มาตรา 3 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 8, 19, 26 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 6) พ.ศ. 2560 มาตรา 7 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 1 พ.ศ. 2561 ลง 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศกระทรวงสาธารณสุขฉบับดังกล่าว ลำดับที่ 38 ประมวลกฎหมายอาญา มาตรา 32, 33, 91 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 6) พ.ศ. 2526 มาตรา 4'	,	'จำคุกตั้งแต่หนึ่งปีถึงสิบปี หรือปรับตั้งแต่สองหมื่นบาทถึงสองแสนบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	16	,	'มียาเสพติดให้โทษประเภท 1 (ยาบ้า) ไว้ในครอบครองเพื่อจำหน่าย'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 15, 66, 102 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 8, 19 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 6) พ.ศ. 2560 มาตรา 3 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 1 พ.ศ. 2561 ลง 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศกระทรวงสาธารณสุขฉบับดังกล่าว ลำดับที่ 38'	,	'จำคุกสิบห้าปี หรือจำคุกตลอดชีวิต'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	17	,	'ร่วมกันมียาเสพติดให้โทษประเภท 1 (ยาบ้า) ไว้ในครอบครอง และเสพ'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 15, 57, 67, 91 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4, 8 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 3) พ.ศ. 2530 มาตรา 3 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 3, 6, 8, 19, 26 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 6) พ.ศ. 2560 มาตรา 7 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 1 พ.ศ. 2561 ลง 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศฉบับดังกล่าว ลำดับที่ 38 ประมวลกฎหมายอาญา มาตรา 83, 91 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 6) พ.ศ. 2526 มาตรา 4'	,	'จำคุกตั้งแต่หนึ่งปีถึงสิบปี หรือปรับตั้งแต่สองหมื่นบาทถึงสองแสนบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	18	,	'ร่วมกันมียาเสพติดให้โทษประเภท 1 (ยาบ้า) ไว้ในครอบครองเพื่อจำหน่าย'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 15, 66, 102 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4, 8 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 8, 19 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 6) พ.ศ. 2560 มาตรา 3 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 1 พ.ศ. 2561 ลง 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศฉบับดังกล่าว ลำดับที่ 38 บัญชีท้ายประกาศกระทรวงสาธารณสุขฉบับดังกล่าว ประมวลกฎหมายอาญา มาตรา 32, 33, 83'	,	'จำคุกสิบห้าปี หรือจำคุกตลอดชีวิต'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	19	,	'ร่วมกันมียาเสพติดให้โทษประเภท 1 (ยาบ้า) ไว้ในครอบครองเพื่อจำหน่าย และเสพ'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 15, 57, 66, 91, 97, 102 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4, 8 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 3, 6, 8, 19, 26 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 6) พ.ศ. 2560 มาตรา 3 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 6) พ.ศ. 2560 มาตรา 3 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 1 พ.ศ. 2561 ลง 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศฉบับดังกล่าว ลำดับที่ 38 ประมวลกฎหมายอาญา มาตรา 32, 33, 83, 91 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 6) พ.ศ. 2526 มาตรา 4'	,	'จำคุกสิบห้าปี หรือจำคุกตลอดชีวิต'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	20	,	'เสพยาเสพติดให้โทษประเภท 2 (ฝิ่น)'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 57, 91 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4, 8 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 3) พ.ศ. 2530 มาตรา 3 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 3, 19, 26 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 2 พ.ศ. 2561 ลง 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศฉบับดังกล่าว ลำดับที่ 103'	,	'จำคุกตั้งแต่หกเดือนถึงสามปี หรือปรับตั้งแต่หนึ่งหมื่นบาทถึงหกหมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	21	,	'เสพและมียาเสพติดให้โทษประเภท 1 (ยาบ้า) ไว้ในครอบครอง,เล่นการพนัน (การพนันครอบครองยาบ้าเสพ)'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 3, 4, 6, 7, 8, 15, 19, 26, 67 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4, 8 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 8, 19 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 6) พ.ศ. 2560 มาตรา 3 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 1 พ.ศ. 2561 ลง 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศฉบับดังกล่าว ลำดับที่ 38 พระราชบัญญัติการพนัน พ.ศ. 2478 มาตรา 4, 5, 6, 10, 12, 15 พระราชบัญญัติการพนัน (ฉบับที่ 5) พ.ศ. 2490 มาตรา 3 พระราชบัญญัติการพนัน (ฉบับที่ 7) พ.ศ. 2504 มาตรา 3 ประมวลกฎหมายอาญา มาตรา 83'	,	'จำคุกตั้งแต่หนึ่งปีถึงสิบปี หรือปรับตั้งแต่สองหมื่นบาทถึงสองแสนบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	22	,	'ร่วมกัน มียาเสพติดให้โทษโทษประเภท 1 (ยาบ้า) ไว้ในครอบครองคำนวณเป็นสารบริสุทธิ์เกินยี่สิบกรัมเพื่อจำหน่ายและจำหน่าย'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 66, 102 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4, 8 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 3) พ.ศ. 2530 มาตรา 3 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 8, 19, 26 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 6) พ.ศ. 2560 มาตรา 3 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 1 พ.ศ. 2561 ลง 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศกระทรวงสาธารณสุขฉบับดังกล่าว ลำดับที่ 38 ประมวลกฎหมายอาญา มาตรา 83, 91 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 6) พ.ศ. 2526 มาตรา 4'	,	'จำคุกตลอดชีวิต และปรับตั้งแต่หนึ่งล้านบาทถึงห้าล้านบาท หรือประหารชีวิต'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	23	,	'มีไม้หวงห้าม (ไม้สักท่อนและไม้สักแปรรูป) ไว้ในครอบครอง และเสพยาเสพติดให้โทษประเภท 1 ยาบ้า (เสพยาบ้า)'	,	'พระราชบัญญัติป่าไม้ พ.ศ. 2484 มาตรา 4, 7, 47, 48, 69, 73, 74 พระราชบัญญัติป่าไม้ (ฉบับที่ 3) พ.ศ. 2494 มาตรา 3 พระราชบัญญัติป่าไม้ (ฉบับที่ 4) พ.ศ. 25036 มาตรา 18 พระราชบัญญัติป่าไม้ (ฉบับที่ 5) พ.ศ. 2518 มาตรา 4, 7, 19 พระราชบัญญัติป่าไม้ (ฉบับที่ 6) พ.ศ. 2522 มาตรา 9 พระราชบัญญัติป่าไม้ (ฉบับที่ 7) พ.ศ. 2525 มาตรา 4 ประกาศของคณะปฏิวัติฉบับที่ 116 พ.ศ. 2515 ข้อ 1 และพระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 57, 91 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4, 8 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 3) พ.ศ. 2530 มาตรา 3 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 3, 6, 8, 19, 26 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 1 พ.ศ. 2561 ออกตามความในพระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 ลงวันที่ 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศกระทรวงสาธารณสุขฉบับดังกล่าว ลำดับที่ 38'	,	'จำคุกตั้งแต่หนึ่งปีถึงยี่สิบปี และปรับตั้งแต่ห้าพันบาทถึงสองแสนบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	24	,	'มียาเสพติดให้โทษโทษประเภท 1 (ยาบ้า) ไว้ในครอบครองคำนวณเป็นสารบริสุทธิ์เกินสามร้อยเจ็ดสิบห้ามิลลิกรัมเพื่อจำหน่าย และจำหน่าย'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 66, 102 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4, 8 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 3) พ.ศ. 2530 มาตรา 3 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 8, 19, 26 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 6) พ.ศ. 2560 มาตรา 3 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 1 พ.ศ. 2561 ออกตามความในพระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 ลงวันที่ 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศกระทรวงสาธารณสุขฉบับดังกล่าว ลำดับที่ 38'	,	'จำคุกตั้งแต่สี่ปีถึงจำคุกตลอดชีวิต และปรับตั้งแต่สี่แสนบาทถึงห้าล้านบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	25	,	'เสพยาเสพติดให้โทษประเภท 1 ยาบ้า (เสพยาบ้า) สรุปกรณีผู้ต้องหาฟื้นฟูเป็นที่พอใจ'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 57, 91 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4, 8 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 3) พ.ศ. 2530 มาตรา 3 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 3, 6, 8, 19, 26 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 1 พ.ศ. 2561 ลง 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศฉบับดังกล่าว ลำดับที่ 38 แต่ในคดีนี้คณะอนุกรรมการฟื้นฟูสมรรถภาพผู้ติดยาเสพติด ได้วินิจฉัยว่าผลการฟื้นฟูสมรรถภาพผู้ติดยาเสพติดซึ่งเป็นผู้ต้องหาในคดีนี้เป็นที่พอใจ และให้ถือว่าผู้ต้องหาได้พ้นจากความผิดที่ถูกกล่าวหา จึงเห็นควรสั่งไม่ฟ้องผู้ต้องหา ตามพระราชบัญญัติฟื้นฟูสมรรถภาพผู้ติดยาเสพติด พ.ศ. 2545 มาตรา 13 (8) และมาตรา 33'	,	'จำคุกตั้งแต่หกเดือนถึงสามปี และปรับตั้งแต่หนึ่งหมื่นบาทถึงหกมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	26	,	'ร่วมกันผลิต และมียาเสพติดให้โทษประเภท 5 (พืชกระท่อม) เพื่อจำหน่าย และร่วมกันมียาแผนปัจจุบันซึ่งเป็นยาอันตรายไว้ในครอบครองเพื่อจำหน่าย'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7 (5), 26 วรรคหนึ่ง, 76/1 วรรคสาม, 102 แก้ไขเพิ่มเติมโดย พ.ร.บ.ยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 23 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 5 พ.ศ. 2561 ลง 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศฉบับดังกล่าว ลำดับที่ 2 พระราชบัญญัติยา พ.ศ. 2510 มาตรา 4, 12, 101 และประมวลกฎหมายอาญา มาตรา 83'	,	'จำคุกไม่เกินสองปี และปรับไม่เกินสี่หมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	27	,	'เสพยาเสพติดให้โทษประเภท 5 (พืชกระท่อม)'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 57, 92 วรรคสอง พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4, 9 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 5 พ.ศ. 2561 ลง 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศฉบับดังกล่าว ลำดับที่ 2'	,	'จำคุกไม่เกินหนึ่งเดือน หรือปรับไม่เกินสองพันบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	28	,	'โฆษณาการนำคนต่างด้าวมาทำงานกับนายจ้างในประเทศ โดยไม่เป็นผู้รับอนุญาตให้นำคนต่างด้าวมาทำงาน'	,	'พระราชกำหนดการบริหารจัดการการทำงานของคนต่างด้าว พ.ศ. 2560 มาตรตรา 5, 25 และมาตรา 104 แก้ไขเพิ่มเติมโดยพระราชกำหนดการบริหารจัดการการทำงานของคนต่างด้าว (ฉบับที่ 2) พ.ศ. 2561'	,	'จำคุกไม่เกินหกเดือน หรือปรับไม่เกินหนึ่งแสนบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	29	,	'ประกอบธุรกิจการนำคนต่างด้าวมาทำงานกับนายจ้างในประเทศโดยไม่ได้รับอนุญาตจากอธิบดี'	,	'พระราชกำหนดการบริหารจัดการการทำงานของคนต่างด้าว พ.ศ. 2560 มาตรตรา 5, 26 และมาตรา 105 แก้ไขเพิ่มเติมโดยพระราชกำหนดการบริหารจัดการการทำงานของคนต่างด้าว (ฉบับที่ 2) พ.ศ. 2561'	,	'จำคุกตั้งแต่หนึ่งปีถึงสามปีหรือปรับตั้งแต่สองแสนบาทถึงหกแสนบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	30	,	'เป็นคนต่างด้าวได้รับอนุญาตอยู่ในราชอาณาจักรชั่วคราวทำงานโดยไม่มีใบอนุญาตทำงานหรือทำงานนอกเหนือจากที่มีสิทธิจะทำได้'	,	'พระราชบัญญัติคนเข้าเมือง พ.ศ. 2522 มาตรา 37 (1), 75 พระราชกำหนดการบริหารการจัดการการทำงานของคนต่างด้าว พ.ศ. 2560 มาตรา 8, 101 แก้ไขเพิ่มเติมโดย พระราชกำหนดการบริหารจัดการการทำงานของคนต่างด้าว (ฉบับที่ 2) พ.ศ. 2561 มาตรา 8, 45'	,	'จำคุกไม่เกินหนึ่งปี หรือปรับไม่เกินหนึ่งหมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	31	,	'เป็นคนต่างด้าวอยู่ในราชอาณาจักรโดยไม่ได้รับอนุญาตหรือการอนุญาตสิ้นสุดหรือถูกเพิกถอน ทำงานนอกเหนือจากสิทธิจะทำได้'	,	'พระราชบัญญัติคนเข้าเมือง พ.ศ. 2522 มาตรา 4, 81 พระราชกำหนดการบริหารการจัดการการทำงานของคนต่างด้าว พ.ศ. 2560 มาตรา 8, 101 แก้ไขเพิ่มเติมโดย พระราชกำหนดการบริหารจัดการการทำงานของคนต่างด้าว (ฉบับที่ 2) พ.ศ. 2561 มาตรา 8, 45'	,	'คุกไม่เกินสองปีหรือปรับไม่เกินสองหมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	32	,	'เป็นคนต่างด้าวหลบหนีเข้ามา และทำงานโดยไม่มีใบอนุญาตทำงานหรือทำงานนอกเหนือจากที่มีสิทธิจะทำได้'	,	'พระราชบัญญัติคนเข้าเมือง พ.ศ. 2522 มาตรา 4, 11, 12, 18, 62, 81 ประกาศกระทรวงมหาดไทย เรื่อง กำหนดที่ตั้งด่านตรวจคนเข้าเมืองและช่องทางให้บุคคลเข้ามาในหรือออกไปนอกราชอาณาจักร และกำหนดให้บุคคลหรือพาหนะที่จะเข้ามาหรือออกไปนอกราชอาณาจักรผ่านการตรวจของพนักงานเจ้าหน้าที่ตรวจคนเข้าเมือง ลงวันที่ 19 มกราคม พ.ศ. 2537 พระราชกำหนดการบริหารการจัดการการทำงานของคนต่างด้าว พ.ศ. 2560 มาตรา 8, 101 แก้ไขเพิ่มเติมโดย พระราชกำหนดการบริหารจัดการการทำงานของคนต่างด้าว (ฉบับที่ 2) พ.ศ. 2561 มาตรา 8, 45'	,	'จำคุกไม่เกินสองปี และปรับไม่เกินสองหมื่นบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	33	,	'บังคับ ขู่เข็ญ ใช้ ชักจูง ยุยง ส่งเสริม หรือยินยอมให้เด็กแสดงหรือกระทำการอันมีลักษณะลามกอนาจาร'	,	'พระราชบัญญัติคุ้มครองเด็ก พ.ศ. 2546 มาตรา 26 (9) และ มาตรา 78'	,	'จำคุกไม่เกินสามเดือน หรือปรับไม่เกินสามหมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	34	,	'แก็งคอลเซนเตอร์ อาชญากรรมข้ามชาติ ทำการเป็นอั้งยี่ ช่องโจร ร่วมกันฉ้อโกง'	,	'ประมวลกฎหมายอาญา มาตรา 341, 342, 343 และมาตรา 83 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 26) พ.ศ. 2560 มาตรา 4'	,	'จำคุกไม่เกินห้าปี หรือปรับไม่เกินหนึ่งแสนบาทหรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	35	,	'ให้คนต่างด้าวเข้าพักอาศัย ซ่อนเร้น หรือช่วยด้วยประการใด ๆ เพื่อให้พ้นจากการจับกุม'	,	'พระราชบัญญัติคนเข้าเมือง พ.ศ. 2522 มาตรา 4, 64'	,	'ต้องระวางโทษจำคุกไม่เกินห้าปี และปรับไม่เกินห้าหมื่นบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	36	,	'เสพยาเสพติดให้โทษประเภท 2 (โคเคอีน) เสพโคเคอีน'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 58, 91 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 3) พ.ศ. 2530 มาตรา 3 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 26 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 2 พ.ศ. 2561 ลง 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศฉบับดังกล่าว ลำดับที่ 20'	,	'จำคุกตั้งแต่หกเดือนถึงสามปี และปรับตั้งแต่หนึ่งหมื่นบาทถึงหกมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	37	,	'รังแก ข่มเหง คุกคาม หรือกระทำให้ได้รับความอับอายหรือเดือดร้อนรำคาญ โดยอาศัยเหตุที่ผู้กระทำมีอำนาจเหนือผู้ถูกกระทำ'	,	'ประมวลกฎหมายอาญา มาตรา 397 วรรคสาม พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 22) พ.ศ. 2558 มาตรา 8'	,	'จำคุกไม่เกินหนึ่งเดือน และปรับไม่เกินหนึ่งหมื่นบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	38	,	'ทารุณต่อเด็กอายุยังไม่เกินสิบห้าปี คนป่วยเจ็บหรือคนชรา ซึ่งต้องพึ่งผู้นั้นในการดำรงชีพหรือการอื่นใด'	,	'ประมวลกฎหมายอาญา มาตรา 398 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 22) พ.ศ. 2558 มาตรา 9'	,	'จำคุกไม่เกินหนึ่งเดือน หรือปรับไม่เกินหนึ่งหมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	39	,	'กระทำชำเราศพ'	,	'ประมวลกฎหมายอาญา มาตรา 366/1 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 22) พ.ศ. 2558 มาตรา 5'	,	'จำคุกไม่เกินสามปีหรือปรับไม่เกินหกหมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	40	,	'กระทำอนาจารศพ'	,	'ประมวลกฎหมายอาญา มาตรา 366/2 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 22) พ.ศ. 2558 มาตรา 5'	,	'จำคุกไม่เกินสองปี หรือปรับไม่เกิน สี่หมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	41	,	'ทํา ผลิต มีไว้ นําเข้าหรือยังให้นําเข้า ส่งออก นอกราชอาณาจักร ซึ่งสื่อลามกอนาจารเด็ก'	,	'ประมวลกฎหมายอาญา มาตรา 1 (17), 287/2 (1) พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 24) พ.ศ. 2558 มาตรา 3, 4'	,	'จําคุกตั้งแต่สามปีถึงสิบปี และปรับตั้งแต่หกหมื่นบาทถึงสองแสนบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	42	,	'ฆ่าผู้อื่นเพื่อจะเอา หรือเอาไว้ซึ่งผลประโยชน์อันเกิดแต่การที่ตนได้กระทำความผิดอื่น'	,	'ประมวลกฎหมายอาญา มาตรา 289 (7)'	,	'ประหารชีวิต'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	43	,	'ชุลมุนต่อสู้ระหว่างบุคคลตั้งแต่สามคน มีผู้ถึงแก่ความตาย'	,	'ประมวลกฎหมายอาญา มาตรา 294 พระราชบัญญัติแก้ไขเพิ่มเติมประมวลกฎหมายอาญา (ฉบับที่ 26) พ.ศ. 2560 มาตรา 4'	,	'จำคุกไม่เกินสองปี หรือปรับไม่เกินสี่หมื่นบาทหรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	44	,	'ขายเครื่องดื่มแอลกอฮอล์ในวัดหรือสถานที่สำหรับปฏิบัติพิธีกรรมทางศาสนา'	,	'พระราชบัญญัติควบคุมเครื่องดื่มแอลกอฮอล์ พ.ศ. 2551 มาตรา 27 (1), 39'	,	'จำคุกไม่เกินหกเดือน หรือปรับไม่เกินหนึ่งหมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	45	,	'ขายเครื่องดื่มแอลกอฮอล์โดยวิธีการหรือในลักษณะใช้เครื่องขายอัตโนมัติ'	,	'พระราชบัญญัติควบคุมเครื่องดื่มแอลกอฮอล์ พ.ศ. 2551 มาตรา 30 (1), 40'	,	'จำคุกไม่เกินหนึ่งปี หรือปรับไม่เกินสองหมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	46	,	'ขายเครื่องดื่มแอลกอฮอล์ในสถานบริการสาธารณสุขของรัฐ สถานพยาบาล ร้านขายยา'	,	'พระราชบัญญัติควบคุมเครื่องดื่มแอลกอฮอล์ พ.ศ. 2551 มาตรา 27 (2), 39'	,	'จำคุกไม่เกินหกเดือน หรือปรับไม่เกินหนึ่งหมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	47	,	'ขายเครื่องดื่มแอลกอฮอล์ในหอพักตามกฎหมายว่าด้วยหอพัก'	,	'พระราชบัญญัติควบคุมเครื่องดื่มแอลกอฮอล์ พ.ศ. 2551 มาตรา 27 (4), 39'	,	'จำคุกไม่เกินหกเดือน หรือปรับไม่เกินหนึ่งหมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	48	,	'ขายเครื่องดื่มแอลกอฮอล์ในสถานศึกษาตามกฎหมายว่าด้วยการศึกษาแห่งชาติ'	,	'พระราชบัญญัติควบคุมเครื่องดื่มแอลกอฮอล์ พ.ศ. 2551 มาตรา 27 (5), 39'	,	'จำคุกไม่เกินหกเดือน หรือปรับไม่เกินหนึ่งหมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	49	,	'มียาเสพติดให้โทษประเภท 5 (เห็ดขี้ควาย) ไว้ในครอบครอง'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 26, 76 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4, 8 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 5) พ.ศ. 2545 มาตรา 22 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 5 พ.ศ. 2561 ลง 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศกดังกล่าว ลำดับที่ 4'	,	'จำคุกไม่เกินห้าปี และปรับไม่เกินหนึ่งแสนบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	50	,	'นำหรือพาของที่ยังมิได้เสียภาษีหรือของต้องจำกัดหรือของต้องห้ามหรือของที่ยังมิได้ผ่านศุลกากร (บุหรี่ ยาสูบ)'	,	'พระราชบัญญัติศุลกากร พ.ศ. 2560 มาตรา 242, 246 พระราชบัญญัติสรรพสามิต พ.ศ. 2560 มาตรา 204, และพระราชบัญญัติยาสูบ พ.ศ. 2509 มาตรา 24, 27, 50'	,	'ปรับตั้งแต่แปดหมื่นบาทถึงหนึ่งแสนบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	51	,	'ฉ้อโกงประชาชน นำเข้าสู่ระบบคอมพิวเตอร์ซึ่งข้อมูลคอมพิวเตอร์ที่บิดเบือนหรือปลอม อันเป็นเท็จ'	,	'ประมวลกฎหมายอาญา มาตรา 83, 341, 343 พระราชบัญญัติคอมพิวเตอร์ พ.ศ. 2550, ฉบัที่ 2 พ.ศ. 2560 มาตรา 14 (1)'	,	'จำคุกตั้งแต่หกเดือนถึงเจ็ดปี และปรับตั้งแต่หนึ่งพันบาทถึงหนึ่งหมื่นสี่พันบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	52	,	'ร่วมกันทำร้ายผู้อื่นได้รับอันตรายสาหัสโดยไตร่ตรองไว้ก่อน'	,	'ประมวลกฎหมายอาญา มาตรา 83, 297, 298'	,	'จำคุกตั้งแต่สองปีถึงสิบปี และปรับตั้งแต่สี่หมื่นบาทถึงสองแสนบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	53	,	'ขับรถโดยประมาทเป็นเหตุให้ผู้อื่นถึงแก่ความตายและรับอันตรายสาหัสและรับอันตรายแก่กายและทรัพย์สินเสียหายและเสพและเป็นผู้ขับขี่เสพยาบ้า'	,	'พระราชบัญญัติจราจรทางบก พ.ศ. 2522 มาตรา 4, 43, 43 ทวิ, 157, 157/1วรรคสอง 160 ตรี (ฉบับที่ 4) พ.ศ. 2535 มาตรา2, 27, 31 (ฉบับที่ 6) พ. ศ.2542 มาตรา 4 (ฉบับที่ 7) พ.ศ. 2550 มาตรา 11 ประมวลกฎหมายอาญา มาตรา 291, 300, 390 พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4, 7, 8, 57, 91 (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4 (ฉบับที่ 5) พ.ศ. 2545 มาตรา 26'	,	'จำคุกตั้งแต่สามปีถึงสิบปี และปรับตั้งแต่หกหมื่นบาทถึงสองแสนบาท'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	54	,	'มีไว้เพื่อจำหน่าย ซึ่งผลิตภัณฑ์อุตสาหกรรม ที่ไม่ได้รับอนุญาตให้ทำหรือนำเข้ามาเพื่อจำหน่าย (เครื่องใช้ไฟฟ้าสำหรับการดูแลผิวหรือผม)'	,	'พระราชบัญญัติมาตรฐานอุตสาหกรรม พ.ศ. 2511 มาตรา 36, 55 พระราชกฤษฎีกากำหนดให้ผลิตภัณฑ์อุตสาหกรรมเครื่องใช้ไฟฟ้าสำหรับการดูแลผิวหรือผมต้องเป็นไปตามมาตรฐาน พ.ศ. 2551 มาตรา 3'	,	'จำคุกไม่เกินหนึ่งเดือน หรือปรับตั้งแต่ห้าพันบาทถึงห้าหมื่นบาท หรือทั้งจำทั้งปรับ'	,	''	);",
"	INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(	55	,	'มียาเสพติดให้โทษประเภท 5 (กัญชา) ไว้ในครอบครองโดยไม่ได้รับอนุญาตเสพกัญชา'	,	'พระราชบัญญัติยาเสพติดให้โทษ พ.ศ. 2522 มาตรา 4,, 7 (5), 58, 8 (1), 26/3, 76วรรค1, 92 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 2) พ.ศ. 2528 มาตรา 4, 8, 9 พระราชบัญญัติยาเสพติดให้โทษ (ฉบับที่ 7) พ.ศ. 2562 มาตรา 13, 18 ประกาศกระทรวงสาธารณสุข เรื่อง ระบุชื่อยาเสพติดให้โทษในประเภท 5 พ.ศ. 2561 ลง 31 กรกฎาคม พ.ศ. 2561 ข้อ 1 บัญชีท้ายประกาศกดังกล่าว ลำดับที่ 1'	,	'ต้องระวางโทษจำคุกตั้งแต่หนึ่งปีถึงห้าปี หรือปรับตั้งแต่สองหมื่นบาทถึงหนึ่งแสนบาท หรือทั้งจำทั้งปรับ'	,	''	);"

            };   
            for(String sql:insertAction){
                          s.addBatch(sql); 
                        
                        }
                        for(String sql2:insertCharge){
                          s2.addBatch(sql2); 
                        
                        }
                      s.executeBatch();
                         s.close();
                          s2.executeBatch();
                         s2.close();
//                         connect.close();
	            // create a new table
//System.out.println("SQLINSERT : "+insertAction);
                    System.out.println("Insert Data Complete");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
                

                
	    }

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        createNewTable();
//                InsertBaseData();
	    }
    
}
