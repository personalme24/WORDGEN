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
                "	Height	VARCHAR(100)	,	\n"+
                "	Weight	VARCHAR(100)	,	\n"+
                "	BloodGroup	VARCHAR(100)	,	\n"+
                "	Related	VARCHAR(100)	,	\n"+
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
                "	DateSendInjured	VARCHAR(100)	,	\n"+
                "	NameSendInjured	VARCHAR(100)	,	\n"+
                "	PlaceBorn	VARCHAR(100)	,	\n"+
                "	DateOfDie	DATETIME	,	\n"+
                "	BodyFoundDate	DATETIME	,	\n"+
                "	DeathLocation	VARCHAR(100)	,	\n"+
                "	TambomDie	VARCHAR(100)	,	\n"+
                "	AmphurDie	VARCHAR(100)	,	\n"+
                "	ProvinceDie	VARCHAR(100)	,	\n"+
                "	PlaceOfFoundBody	VARCHAR(100)	,	\n"+
                "	TambomFoundBody	VARCHAR(100)	,	\n"+
                "	AmphurFoundBody	VARCHAR(100)	,	\n"+
                "	ProvinceFoundBody	VARCHAR(100)	,	\n"+
                "	CircumstancesOfDeath	VARCHAR(100)	,	\n"+
                "	ArrestDate	VARCHAR(100)	,	\n"+
                "	ArrestTime	VARCHAR(100)	,	\n"+                                           
                "	PlaceArrest	VARCHAR(100)	,	\n"+
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
                "	TimeOfDie	VARCHAR(100)	,	\n"+
                "	BodyFoundTime	VARCHAR(100)	,	\n"+
                "	RelatedOfDie	VARCHAR(100)	,	\n"+
                "	InterrogateDate	VARCHAR(100)	,	\n"+
                "	CurrentAddress	VARCHAR(100)	,	\n"+
                "	ArrestDateTime	VARCHAR(100)	,	\n"+
                "	StatusSueAndPutInJail	VARCHAR(100)	,	\n"+
                "	NumberImprison	VARCHAR(100)	,	\n"+
                "	SinceImprison	VARCHAR(100)	,	\n"+
                "	SinceImprisonTime	VARCHAR(100)	,	\n"+
                "	ToImprison	VARCHAR(100)	,	\n"+
                "	ToImprisonTime	VARCHAR(100)	,	\n"+
                "	TotalDate	VARCHAR(100)	,	\n"+
                "	TotalTime	VARCHAR(100)	,	\n"+
                "	StatusSuspect	VARCHAR(100)	,	\n"+
                "	BailDate	VARCHAR(100)	,	\n"+
                "	RestoreDate	VARCHAR(100)	,	\n"+ 
                "	Road     	VARCHAR(100)	,	\n"+
                "	Soi     	VARCHAR(100)	,	\n"+  
                "	SueLastEndDate	VARCHAR(100)	,	\n"+  
                "	CourtSuspect	VARCHAR(100)	,	\n"+    
                "	Test1	VARCHAR(100)	,	\n"+    
                "	Test2	VARCHAR(100)	,	\n"+ 
                "	SueFirst	INTEGER	,	\n"+
                "	SueFirstDate	DateTime	,	\n"+
                "	SueFirstStart	DateTime	,	\n"+
                "	SueFirstEnd	DateTime	,	\n"+
                "	SueFirstTotal	INTEGER	,	\n"+
                "	SueFirstRequest	VARCHAR(100)	,	\n"+
                "	SueFirstCause	VARCHAR(100)	,	\n"+
                "	SueSecond	INTEGER	,	\n"+
                "	SueSecDate	DateTime	,	\n"+
                "	SueSecStart	DateTime	,	\n"+
                "	SueSecEnd	DateTime	,	\n"+
                "	SueSecTotal	INTEGER	,	\n"+
                "	SueSecRequest	VARCHAR(100)	,	\n"+
                "	SueSecCause	VARCHAR(100)	,	\n"+
                "	SueThird	INTEGER	,	\n"+
                "	SueThirdDate	DateTime	,	\n"+
                "	SueThirdStart	DateTime	,	\n"+
                "	SueThirdEnd	DateTime	,	\n"+
                "	SueThirdTotal	INTEGER	,	\n"+
                "	SueThirdRequest	VARCHAR(100)	,	\n"+
                "	SueThirdCause	VARCHAR(100)	,	\n"+
                "	SueFourth	INTEGER	,	\n"+
                "	SueFourthDate	DateTime	,	\n"+
                "	SueFourthStart	DateTime	,	\n"+
                "	SueFourthEnd	DateTime	,	\n"+
                "	SueFourthtotal	INTEGER	,	\n"+
                "	SueFourthRequest	VARCHAR(100)	,	\n"+
                "	SueFourthCause	VARCHAR(100)	,	\n"+
                "	SueFifth	INTEGER	,	\n"+
                "	SueFifthDate	DateTime	,	\n"+
                "	SueFifthStart	DateTime	,	\n"+
                "	SueFifthEnd	DateTime	,	\n"+
                "	SueFifthTotal	INTEGER	,	\n"+
                "	SueFifthRequest	VARCHAR(100)	,	\n"+
                "	SueFifthCause	VARCHAR(100)	,	\n"+
                "	SueSixth	INTEGER	,	\n"+
                "	SueSixthDate	DateTime	,	\n"+
                "	SueSixthStart	DateTime	,	\n"+
                "	SueSixthEnd	DateTime	,	\n"+
                "	SueSixthTotal	INTEGER	,	\n"+
                "	SueSixthRequest	VARCHAR(100)	,	\n"+
                "	SueSixthCause	VARCHAR(100)	,	\n"+
                "	SueSeven	INTEGER	,	\n"+
                "	SueSevenDate	DateTime	,	\n"+
                "	SueSevenStart	DateTime	,	\n"+
                "	SueSevenEnd	DateTime	,	\n"+
                "	SueSevenTotal	INTEGER	,	\n"+
                "	SueSevenRequest	VARCHAR(100)	,	\n"+
                "	SueSevenCause	VARCHAR(100)	,	\n"+                        
                "	caseIdPerson	INTEGER	not null	\n"+
                "	);	";	

                       
                  String sqlCrimeCase ="CREATE TABLE IF NOT EXISTS CrimeCase (\n"+
                       "	CaseId	INTEGER	Primary Key AUTOINCREMENT,	\n"+
                        "	CaseType	VARCHAR(100)	,	\n"+
                        "	SendIDocDate	DATE	,	\n"+
                        "	crimecaseno	VARCHAR(100)	not null,	\n"+
                        "	crimecaseyears	VARCHAR(100)	,	\n"+
                        "	crimecasenoyear	VARCHAR(100)	,	\n"+
                        "	OccuredDate	DATE	,	\n"+
                        "	CaseAcceptDate	DATE	,	\n"+
                        "	CaseRequestDate	DATE	,	\n"+
                        "	OccuredTime	TIME	,	\n"+
                        "	CaseAccepTime	TIME	,	\n"+
                        "	CaseRequestTime	TIME	,	\n"+
                        "	ChargeCodeCase	VARCHAR(100)	,	\n"+
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
                        "	ActionCodeCase	VARCHAR(100)	,	\n"+
                        "	TypeCourt	VARCHAR(100)	,	\n"+
                        "	BlackCaseNo	VARCHAR(100)	,	\n"+
                        "	BlackCaseYear	VARCHAR(100)	,	\n"+
                        "	RedCaseNo	VARCHAR(100)	,	\n"+
                        "	RedCaseYear	VARCHAR(100)	,	\n"+
                        "	AnswerSuspect	VARCHAR(100)	,	\n"+
                        "	AnswerAccuser   	VARCHAR(100)	,	\n"+
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
	                "	IdCardPolice	VARCHAR(13)	Primary Key,	\n"+
                        "	RankPolice	VARCHAR(100)	,	\n"+
                        "	FirstName	VARCHAR(100)	,	\n"+
                        "	LastName	VARCHAR(100)	,	\n"+
                        "	Position	VARCHAR(100)		\n"+
                         "	);";
	  String sqlPoliceStat ="CREATE TABLE IF NOT EXISTS PoliceStation (\n"+
	              "	PoliceStartionCode	VARCHAR(100)	Primary Key,	\n"+
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
                        "	HeadName	VARCHAR(100)	,	\n"+
                        "	HeadPosition	VARCHAR(100)	,	\n"+
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
           String sqlCharge ="CREATE TABLE IF NOT EXISTS Charge (\n"+
	            "	ChargeCode	VARCHAR(100)	Primary Key,	\n"+
                    "	ChargeName	VARCHAR(100)	,	\n"+
                    "	Law	VARCHAR(100)	,	\n"+
                    "	RateOfPenalty	VARCHAR(100)	,	\n"+
                    "	Note	VARCHAR(100)		\n"+
                         "	);";      
           
            String sqlAction ="CREATE TABLE IF NOT EXISTS ActionsCase (\n"+
                    "	ActionCode	VARCHAR(100)	Primary Key,	\n"+
                    "	ActionCrimes	VARCHAR(100)	,	\n"+
                    "	ActionDetail	VARCHAR(100)	,	\n"+
                    "	ActionNote	VARCHAR(100)		\n"+
                    "	);";    
            String sqlRecord ="CREATE TABLE IF NOT EXISTS RecordInquiry (\n"+
                    "	IdRecord	INTEGER	Primary Key AUTOINCREMENT,	\n"+
                    "	DateRecord	VARCHAR(100)	,	\n"+
                    "	NameInguiry	VARCHAR(100)	,	\n"+
                    "	DetailRecord	VARCHAR(100)	,	\n"+
                    "	CaseIdRecord	INTEGER	not null	\n"+    
                    "	);";   
             String sqlInvest ="CREATE TABLE IF NOT EXISTS InvestInformation (\n"+
	             "	InvestId	INTEGER	Primary Key Not Null,	\n"+
                     "	InvestCardID	VARCHAR(100)	,	\n"+
                    "	InvestName	VARCHAR(100)	,	\n"+
                    "	InvestPosition	VARCHAR(100)	,	\n"+
                    "	InvestBirthDay	VARCHAR(100)	,	\n"+
                    "	InvestAge	VARCHAR(100)	,	\n"+
                    "	InvestTel	VARCHAR(100)		\n"+
                    "	);";
             
               String sqlSue ="CREATE TABLE IF NOT EXISTS Sue (\n"+
	       "	SueId	INTEGER	Primary Key AUTOINCREMENT,	\n"+
                "	SueTimes	INTEGER	,	\n"+
                "	SueDate	VARCHAR(100)	,	\n"+
                "	SueStart	VARCHAR(100)	,	\n"+
                "	SueEnd	VARCHAR(100)	,	\n"+
                "	SueTotal	INTEGER	,	\n"+
                "	SueCause	VARCHAR(100)	,	\n"+
                "	SueRequest	VARCHAR(100)	,	\n"+
                "	SuePersonId	INTEGER	not null, \n"+	
                "	SueCaseId	INTEGER	not null		\n"+
                    "	);";
               
            String sqlBailAsset ="CREATE TABLE IF NOT EXISTS BailAsset (\n"+
                            "	BailAssetId	INTEGER	Primary Key AUTOINCREMENT,	\n"+
                            "	BailAssetOrder	INTEGER	,	\n"+
                            "	BailAssetDetail	VARCHAR(100)	,	\n"+
                            "	BailAssetBath	VARCHAR(100)	,	\n"+
                            "	BailAssetTotal	VARCHAR(100)	,	\n"+
                            "	BailAssetRemark	VARCHAR(100)	,	\n"+
                            "	BailCaseId	INTEGER	,	\n"+
                            "	BailPersonId	INTEGER		\n"+
                    "	);";
             String sqlBail ="CREATE TABLE IF NOT EXISTS Bail (\n"+
                              "	BailAssetId	INTEGER	Primary Key AUTOINCREMENT,	\n"+
                                "	BailAssetOrder	INTEGER	,	\n"+
                                "	BailAssetDetail	VARCHAR(100)	,	\n"+
                                "	BailAssetBath	VARCHAR(100)	,	\n"+
                                "	BailAmount	VARCHAR(100)	,	\n"+
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
                                "	DeliPersonId	INTEGER		\n"+         
                                "	);"; 
                
        String sqlSueCrimeCase ="CREATE TABLE IF NOT EXISTS SueCrimeCase (\n"+                
                "	SueId	INTEGER	Primary Key AUTOINCREMENT,	\n"+
                "	SueFirst	INTEGER	,	\n"+
                "	SueFirstDate	DateTime	,	\n"+
                "	SueFirstStart	DateTime	,	\n"+
                "	SueFirstEnd	DateTime	,	\n"+
                "	SueFirstTotal	INTEGER	,	\n"+
                "	SueFirstRequest	VARCHAR(100)	,	\n"+
                "	SueFirstCause	VARCHAR(100)	,	\n"+
                "	SueSecond	INTEGER	,	\n"+
                "	SueSecDate	DateTime	,	\n"+
                "	SueSecStart	DateTime	,	\n"+
                "	SueSecEnd	DateTime	,	\n"+
                "	SueSecTotal	INTEGER	,	\n"+
                "	SueSecRequest	VARCHAR(100)	,	\n"+
                "	SueSecCause	VARCHAR(100)	,	\n"+
                "	SueThird	INTEGER	,	\n"+
                "	SueThirdDate	DateTime	,	\n"+
                "	SueThirdStart	DateTime	,	\n"+
                "	SueThirdEnd	DateTime	,	\n"+
                "	SueThirdTotal	INTEGER	,	\n"+
                "	SueThirdRequest	VARCHAR(100)	,	\n"+
                "	SueThirdCause	VARCHAR(100)	,	\n"+
                "	SueFourth	INTEGER	,	\n"+
                "	SueFourthDate	DateTime	,	\n"+
                "	SueFourthStart	DateTime	,	\n"+
                "	SueFourthEnd	DateTime	,	\n"+
                "	SueFourthtotal	INTEGER	,	\n"+
                "	SueFourthRequest	VARCHAR(100)	,	\n"+
                "	SueFourthCause	VARCHAR(100)	,	\n"+
                "	SueFifth	INTEGER	,	\n"+
                "	SueFifthDate	DateTime	,	\n"+
                "	SueFifthStart	DateTime	,	\n"+
                "	SueFifthEnd	DateTime	,	\n"+
                "	SueFifthTotal	INTEGER	,	\n"+
                "	SueFifthRequest	VARCHAR(100)	,	\n"+
                "	SueFifthCause	VARCHAR(100)	,	\n"+
                "	SueSixth	INTEGER	,	\n"+
                "	SueSixthDate	DateTime	,	\n"+
                "	SueSixthStart	DateTime	,	\n"+
                "	SueSixthEnd	DateTime	,	\n"+
                "	SueSixthTotal	INTEGER	,	\n"+
                "	SueSixthRequest	VARCHAR(100)	,	\n"+
                "	SueSixthCause	VARCHAR(100)	,	\n"+
                "	SueSeven	INTEGER	,	\n"+
                "	SueSevenDate	DateTime	,	\n"+
                "	SueSevenStart	DateTime	,	\n"+
                "	SueSevenEnd	DateTime	,	\n"+
                "	SueSevenTotal	INTEGER	,	\n"+
                "	SueSevenRequest	VARCHAR(100)	,	\n"+
                "	SueSevenCause	VARCHAR(100)	,	\n"+
                "	SueCaseId	INTEGER	 not null,	\n"+
                "	SueSuspectId	INTEGER	not null	\n"+
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
                      stmt.execute(sqlSue);
                       stmt.execute(sqlBailAsset);
                      stmt.execute(sqlBail);
                      stmt.execute(sqlDeliverySuspect);
                      stmt.execute(sqlSueCrimeCase);

                       stmt.close();
                    System.out.println("Create Table Complete");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
                
                
//                String intCharge="INSERT INTO Charge (ChargeCode,ChargeName,Law,RateOfPenalty,Note) VALUES ('1','ลักทรัพย์','dsfdfs','asdasdsadda','');\n"+
//                                 "INSERT INTO Charge (ChargeCode,ChargeName,Law,RateOfPenalty,Note) VALUES ('2','ค้ายา','','','');\n"+
//                                 "INSERT INTO Charge (ChargeCode,ChargeName,Law,RateOfPenalty,Note) VALUES ('3','ฆ่าผู้อื่นโดยเจตนา','','','');";
//                 System.out.println("insert completely : "+intCharge);
//        PreparedStatement pst=null;
//         try { 
//            pst=cc.prepareStatement(intCharge);
//            pst.executeUpdate();
//            pst.close();
//            System.out.println("insert completely : "+intCharge);
//           
//        } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, e); 
//             System.out.println("SQL : "+pst);
//        }

                
	    }
	 
	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        createNewTable();
	    }
    
}
