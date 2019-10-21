/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

/**
 *
 * @author Computer
 */

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class ThaiCardDetail implements Serializable {
	private static final long serialVersionUID = 2139455644282650617L;
	private String pid;
	private String cid;
	private String thname;
	private String thname0;
	private String thname1;
	private String thname3;
	private String enname;
	private String birthdate;
	private String gender;
	private String enname0;
	private String enname1;
	private String enname3;
	private String addr;
	private String issuedate;
	private String expiredate;
	private byte[] image;
	private List<Byte> image_list;
	private String person_img;
	private String addrHS;
	private String addrMoo;
	private String addrTrk;
	private String addrSoi;
	private String addrStr;
	private String addrTmb;
	private String addrAmp;
	private String addrPrv;

	public String getPid() {
		return this.pid;
	}

	public String getCid() {
		return this.cid;
	}

	public String getThname() {
		return this.thname;
	}

	public String getThname0() {
		return this.thname0;
	}

	public String getThname1() {
		return this.thname1;
	}

	public String getThname3() {
		return this.thname3;
	}

	public String getEnname() {
		return this.enname;
	}

	public String getBirthdate() {
		return this.birthdate;
	}

	public String getGender() {
		return this.gender;
	}

	public String getEnname0() {
		return this.enname0;
	}

	public String getEnname1() {
		return this.enname1;
	}

	public String getEnname3() {
		return this.enname3;
	}

	public String getAddr() {
		return this.addr;
	}

	public String getIssuedate() {
		return this.issuedate;
	}

	public String getExpiredate() {
		return this.expiredate;
	}

	public String getPerson_img() {
		return this.person_img;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public void setThname(String thname) {
		this.thname = thname;
	}

	public void setThname0(String thname0) {
		this.thname0 = thname0;
	}

	public void setThname1(String thname1) {
		this.thname1 = thname1;
	}

	public void setThname3(String thname3) {
		this.thname3 = thname3;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setEnname0(String enname0) {
		this.enname0 = enname0;
	}

	public void setEnname1(String enname1) {
		this.enname1 = enname1;
	}

	public void setEnname3(String enname3) {
		this.enname3 = enname3;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public void setExpiredate(String expiredate) {
		this.expiredate = expiredate;
	}

	public void setPerson_img(String person_img) {
		this.person_img = person_img;
	}

	public byte[] getImage() {
		return this.image;
	}

	public List<Byte> getImage_list() {
		return this.image_list;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public void setImage_list(List<Byte> image_list) {
		this.image_list = image_list;
	}

	public String getAddrHS() {
		return this.addrHS;
	}

	public String getAddrMoo() {
		return this.addrMoo;
	}

	public String getAddrTrk() {
		return this.addrTrk;
	}

	public String getAddrSoi() {
		return this.addrSoi;
	}

	public String getAddrStr() {
		return this.addrStr;
	}

	public String getAddrTmb() {
		return this.addrTmb;
	}

	public String getAddrAmp() {
		return this.addrAmp;
	}

	public String getAddrPrv() {
		return this.addrPrv;
	}

	public void setAddrHS(String addrHS) {
		this.addrHS = addrHS;
	}

	public void setAddrMoo(String addrMoo) {
		this.addrMoo = addrMoo;
	}

	public void setAddrTrk(String addrTrk) {
		this.addrTrk = addrTrk;
	}

	public void setAddrSoi(String addrSoi) {
		this.addrSoi = addrSoi;
	}

	public void setAddrStr(String addrStr) {
		this.addrStr = addrStr;
	}

	public void setAddrTmb(String addrTmb) {
		this.addrTmb = addrTmb;
	}

	public void setAddrAmp(String addrAmp) {
		this.addrAmp = addrAmp;
	}

	public void setAddrPrv(String addrPrv) {
		this.addrPrv = addrPrv;
	}
}

