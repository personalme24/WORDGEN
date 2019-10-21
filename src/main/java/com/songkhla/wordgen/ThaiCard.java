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
public class ThaiCard {
	private int status;
	private ThaiCardDetail thaiCardDetail;

	public int getStatus() {
		return this.status;
	}

	public String getStatusMsg() {
		switch (this.status) {
		case 0:
			return "Exception";
		case 1:
			return "CardException";
		case 2:
			return "CardNotPresentException";
		case 3:
			return "Ready";
		case 4:
			return "Success";
		}
		return "";
	}

	public ThaiCardDetail getThaiCardDetail() {
		return this.thaiCardDetail;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setThaiCardDetail(ThaiCardDetail thaiCardDetail) {
		this.thaiCardDetail = thaiCardDetail;
	}
}

