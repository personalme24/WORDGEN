/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
	                 "	PeopleRegistrationID	VARCHAR(13)	Primary Key,	\n"+
                "	StatusSuspect		,	\n"+
                "	SuspectType		,	\n"+
                "	Isforeigner		,	\n"+
                "	FullNamePerson	VARCHAR(100)	,	\n"+
                "	Age	VARCHAR(100)	,	\n"+
                "	Race	VARCHAR(100)	,	\n"+
                "	Nationality	VARCHAR(100)	,	\n"+
                "	Religion	VARCHAR(100)	,	\n"+
                "	Occupation	VARCHAR(100)	,	\n"+
                "	PersonType		,	\n"+
                "	IssueDate	DATETIME	,	\n"+
                "	ExpiredDate	DATETIME	,	\n"+
                "	IssuedBy	VARCHAR(100)	,	\n"+
                "	HouseNumber	VARCHAR(100)	,	\n"+
                "	Moo	VARCHAR(100)	,	\n"+
                "	Tambon	VARCHAR(100)	,	\n"+
                "	Amphur	VARCHAR(100)	,	\n"+
                "	Province	VARCHAR(100)	,	\n"+
                "	HeadmanName	VARCHAR(100)	,	\n"+
                "	SubHeadmanName	VARCHAR(100)	,	\n"+
                "	FatherFullName	VARCHAR(100)	,	\n"+
                "	MotherFullName	VARCHAR(100)	,	\n"+
                "	Relative	VARCHAR(100)	,	\n"+
                "	TambonBirthday	VARCHAR(100)	,	\n"+
                "	AmphurBirthday	VARCHAR(100)	,	\n"+
                "	ProvinceBirthday	VARCHAR(100)	,	\n"+
                "	DateOfDie	DATETIME	,	\n"+
                "	DateOfFoundCorpse	DATETIME	,	\n"+
                "	PlaceOfDie	VARCHAR(100)	,	\n"+
                "	PlaceOfFoundCorpse	VARCHAR(100)	,	\n"+
                "	NameOfFoundCorpse	VARCHAR(100)	,	\n"+
                "	Gender	VARCHAR(100)	,	\n"+
                "	HeightFoot	Boolean	,	\n"+
                "	HeightInch	Boolean	,	\n"+
                "	HeightMeters	Boolean	,	\n"+
                "	Shape	Boolean	,	\n"+
                "	Skin	Boolean	,	\n"+
                "	Face	Boolean	,	\n"+
                "	Hair	Boolean	,	\n"+
                "	Beard	Boolean	,	\n"+
                "	Eyebrow	Boolean	,	\n"+
                "	Eye	Boolean	,	\n"+
                "	Head	Boolean	,	\n"+
                "	Forehead	Boolean	,	\n"+
                "	Nose	Boolean	,	\n"+
                "	Mouth	Boolean	,	\n"+
                "	Neck	Boolean	,	\n"+
                "	Chin	Boolean	,	\n"+
                "	Teeth	Boolean	,	\n"+
                "	Ear	Boolean	,	\n"+
                "	Hand	Boolean	,	\n"+
                "	Scar	Boolean	,	\n"+
                "	Tattoo	Boolean	,	\n"+
                "	Dress	Boolean	,	\n"+
                "	SpecialCharacter	VARCHAR(100)	,	\n"+
                "	CauseFoundBody	VARCHAR(100)	,	\n"+
                "	CauseOfDeath	VARCHAR(100)	,	\n"+
                "	FullNamePersonEn	VARCHAR(100)	,	\n"+
                "	PassportNumber	VARCHAR(100)	,	\n"+
                "	OtherName	VARCHAR(100)	,	\n"+
                "	OtherSurname	VARCHAR(100)	,	\n"+
                "	BirthDay	DATE	,	\n"+
                "	FatherAddress	VARCHAR(100)	,	\n"+
                "	MotherAddress	VARCHAR(100)	,	\n"+
                "	SpouseFullName	VARCHAR(100)	,	\n"+
                "	SpouseAddress	VARCHAR(100)	,	\n"+
                "	RelativeFriend	VARCHAR(100)	,	\n"+
                "	RelativeFriendAddress	VARCHAR(100)	,	\n"+
                "	workplace	VARCHAR(100)	,	\n"+
                "	LastAddress	VARCHAR(100)	,	\n"+
                "	Domicile	VARCHAR(100)	,	\n"+
                "	FavouritePlace	VARCHAR(100)	,	\n"+
                "	Gang	VARCHAR(100)	,	\n"+
                "	NamePeopleInTheGang	VARCHAR(100)	,	\n"+
                "	Height	VARCHAR(100)	,	\n"+
                "	Weight	VARCHAR(100)	,	\n"+
                "	BloodGroup	VARCHAR(100)	,	\n"+
                "	Disability	VARCHAR(100)	,	\n"+
                "	HeirName	VARCHAR(100)	,	\n"+
                "	DangerouspersonName	VARCHAR(100)	,	\n"+
                "	DriverName	VARCHAR(100)	,	\n"+
                "	RegistrationNumber	VARCHAR(100)	,	\n"+
                "	NoPlate_number	VARCHAR(100)	,	\n"+
                "	TravelDate	DATETIME	,	\n"+
                "	Vehicle	VARCHAR(100)	,	\n"+
                "	FlightNo	VARCHAR(100)	,	\n"+
                "	BossName	VARCHAR(100)	,	\n"+
                "	Country	VARCHAR(100)	,	\n"+
                "	MissingPersonNo	VARCHAR(100)	,	\n"+
                "	InformerName	VARCHAR(100)	,	\n"+
                "	InformerHouseNo	VARCHAR(100)	,	\n"+
                "	InformerMoo	VARCHAR(100)	,	\n"+
                "	InformerRoad	VARCHAR(100)	,	\n"+
                "	InformerTambon	VARCHAR(100)	,	\n"+
                "	InformerAmphur	VARCHAR(100)	,	\n"+
                "	InformerProvince	VARCHAR(100)	,	\n"+
                "	TitleName	VARCHAR(100)	,	\n"+
                "	AliasName	VARCHAR(100)	,	\n"+
                "	DomicileHouseNo	VARCHAR(100)	,	\n"+
                "	DomicileMoo	VARCHAR(100)	,	\n"+
                "	DomicileRoad	VARCHAR(100)	,	\n"+
                "	DomicileTambon	VARCHAR(100)	,	\n"+
                "	DomicileAmphur	VARCHAR(100)	,	\n"+
                "	DomicileProvince	VARCHAR(100)	,	\n"+
                "	WhenLostHouseNo	VARCHAR(100)	,	\n"+
                "	WhenLostMoo	VARCHAR(100)	,	\n"+
                "	WhenLostRoad	VARCHAR(100)	,	\n"+
                "	WhenLostTambon	VARCHAR(100)	,	\n"+
                "	WhenLostAumphur	VARCHAR(100)	,	\n"+
                "	WhenLostProvince	VARCHAR(100)	,	\n"+
                "	CauseOfLost	VARCHAR(100)	,	\n"+
                "	PlaceFindOut	VARCHAR(100)	,	\n"+
                "	LostDateCostume	VARCHAR(100)	,	\n"+
                "	CarryOnAsset	VARCHAR(100)	,	\n"+
                "	PresumptionOfLost	VARCHAR(100)	,	\n"+
                "	ConsignTo	VARCHAR(100)	,	\n"+
                "	FollowName	VARCHAR(100)	,	\n"+
                "	DateOfVisit	VARCHAR(100)	,	\n"+
                "	caseno	integer	,	\n"+
                "	 FOREIGN KEY (caseno) REFERENCES CrimeCase (caseno)\n"+
                "	);	";	

                       
                  String sqlCrimeCase ="CREATE TABLE IF NOT EXISTS CrimeCase (\n"+
	                 "	caseno	integer	Primary Key Not Null,	\n"+
                "	caseyear	integer	not null,	\n"+
                "	DisplayCharge	VARCHAR(100)	,	\n"+
                "	OccuredDateTime	DATETIME	,	\n"+
                "	CaseRequestDateTime	DATETIME	,	\n"+
                "	CaseAcceptDateTime	DATETIME	,	\n"+
                "	Obstruction	VARCHAR(100)	,	\n"+
                "	RecordCheckDate	DATETIME	,	\n"+
                "	RecordCheck	VARCHAR(100)	,	\n"+
                "	RecordCheckEdit	VARCHAR(100)	,	\n"+
                "	AmountCopyInvestigate	integer	,	\n"+
                "	ComplainDateTime	DATETIME	,	\n"+
                "	FactAndComment	VARCHAR(100)	,	\n"+
                "	BecauseNonNatureOfDeath	VARCHAR(100)	,	\n"+
                "	BodyFoundDate	DATETIME	,	\n"+
                "	DoctorCheckฺBodyID	VARCHAR(100)	,	\n"+
                "	DoctorCheckฺBody	VARCHAR(100)	,	\n"+
                "	DoctorCheckฺBodyDate	DATETIME	,	\n"+
                "	DailyNumber	VARCHAR(100)	,	\n"+
                "	CheckDate	DATETIME	,	\n"+
                "	CheckDateTimeFrom	DATETIME	,	\n"+
                "	CheckDateTimeTo	DATETIME	,	\n"+
                "	CrimeLocation	VARCHAR(100)	,	\n"+
                "	CrimeLocationMoo	VARCHAR(100)	,	\n"+
                "	CrimeLocationSoi	VARCHAR(100)	,	\n"+
                "	CrimeLocationRoad	VARCHAR(100)	,	\n"+
                "	CrimeLocationDistrict	VARCHAR(100)	,	\n"+
                "	CrimeLocationAmphur	VARCHAR(100)	,	\n"+
                "	CrimeLocationProvince	VARCHAR(100)	,	\n"+
                "	EvidenceFoundOfCrime	VARCHAR(100)	,	\n"+
                "	CauseOfCrime	VARCHAR(100)	,	\n"+
                "	DamageOfCrime	VARCHAR(100)	,	\n"+
                "	StuffFromScence	VARCHAR(100)	,	\n"+
                "	Presumption	VARCHAR(100)	,	\n"+
                "	MaterialSkinTraffic	VARCHAR(100)	,	\n"+
                "	QualiytSkinTraffic	VARCHAR(100)	,	\n"+
                "	HumidityTraffic	VARCHAR(100)	,	\n"+
                "	HumidityTrafficOccured	VARCHAR(100)	,	\n"+
                "	HumidityTrafficChecking	VARCHAR(100)	,	\n"+
                "	WidthSkinTraffic	VARCHAR(100)	,	\n"+
                "	FoothpathTraffuc	VARCHAR(100)	,	\n"+
                "	LevelOfFoothpath	VARCHAR(100)	,	\n"+
                "	DirecStraightOrCurve	VARCHAR(100)	,	\n"+
                "	Crossroad	VARCHAR(100)	,	\n"+
                "	MasterRoad	VARCHAR(100)	,	\n"+
                "	DividinglineRoad	VARCHAR(100)	,	\n"+
                "	SignSpeed	VARCHAR(100)	,	\n"+
                "	Municipality	VARCHAR(100)	,	\n"+
                "	OtherSign	VARCHAR(100)	,	\n"+
                "	MarksTier	VARCHAR(100)	,	\n"+
                "	OrtherMark	VARCHAR(100)	,	\n"+
                "	DescriptionMap	VARCHAR(100)		\n"+
                "	);";
      
          String sqlAsset ="CREATE TABLE IF NOT EXISTS Asset (\n"+
	                 "	EvidenceRecordNumber	VARCHAR(100)	Primary Key Not Null,	\n"+
                "	Isconflagration		,	\n"+
                "	AssetType		,	\n"+
                "	StatusAsset		,	\n"+
                "	IsVehicle		,	\n"+
                "	Name	VARCHAR(100)	,	\n"+
                "	Amount	Integer	,	\n"+
                "	Value	Double	,	\n"+
                "	OccupantName	VARCHAR(100)	,	\n"+
                "	Note	VARCHAR(100)	,	\n"+
                "	NoPlateNumber	VARCHAR(100)	,	\n"+
                "	NoPlateProvince	VARCHAR(100)	,	\n"+
                "	NameCar	VARCHAR(100)	,	\n"+
                "	VehicleDetail	VARCHAR(100)	,	\n"+
                "	TypeName	VARCHAR(100)	,	\n"+
                "	SpeicalDetail	VARCHAR(100)	,	\n"+
                "	EstimatedValue	VARCHAR(100)	,	\n"+
                "	FoundLocation	VARCHAR(100)	,	\n"+
                "	FoundDate	DATETIME	,	\n"+
                "	FoundMethod	VARCHAR(100)	,	\n"+
                "	RegainAsset	VARCHAR(100)	,	\n"+
                "	DetailAssetLost	VARCHAR(100)	,	\n"+
                "	CauseAssetLost	VARCHAR(100)	,	\n"+
                "	TotalAsset	Double	,	\n"+
                "	ValueAsset	Double	,	\n"+
                "	TotalRegainAsset	Double	,	\n"+
                "	ValueRegainAsset	Double	,	\n"+
                "	BehaviorAndFact	VARCHAR(100)	,	\n"+
                "	PlaceFoundExhibit	VARCHAR(100)	,	\n"+
                "	ListExhibit	VARCHAR(100)	,	\n"+
                "	PurposeCheck	VARCHAR(100)	,	\n"+
                "	caseno	integer	,	\n"+
                "	 FOREIGN KEY (caseno) REFERENCES CrimeCase (caseno)\n"+
                "	);";
          String sqlTest ="CREATE TABLE IF NOT EXISTS Test (\n"+
	                 "	id	int	Primary Key Not Null,	\n"+
                "	name	varchar(100)		\n"+         
                "	);";
	        
	        try ( 
                        Statement stmt = cc.createStatement()) {
	            // create a new table
                   
	            stmt.execute(sqlPerson);
                     stmt.execute(sqlCrimeCase); 
                     stmt.execute(sqlAsset); 
                     stmt.execute(sqlTest); 
                    System.out.println("Create Table Complete");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	 
	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        createNewTable();
	    }
            
}
