package telran.exceptions.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.exceptions.BallBrokenFloor;

class BallBrokenFloorTest {

	private static final int N_FLOORS = 100;

	@Test
	void BrokenFloorTest() {
		BallBrokenFloor bbf = new BallBrokenFloor(N_FLOORS);
		assertEquals(bbf.getBrokenFloor(), getMinBrokenFloor(bbf));
	}

	private int getMinBrokenFloor(BallBrokenFloor bbf) {
		int left = 1;
		int right = N_FLOORS;
		
		while(left < right) {
			int mid = left + (right - left) / 2;
			try {
				bbf.checkFloor(mid);
				left = mid + 1;
			} catch (Exception e) {
				right = mid;
			}
		}
		return left;
	}

}