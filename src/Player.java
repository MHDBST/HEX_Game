public class Player {
	private int size;

	public Player(int size) {
		this.size = size;
	}

	public void play(Table table, char color) {
		// coordination of the point we will choose
		int i = -1 ,j = -1;

		// for red player
		if (color == 'r') {
			// final value of the root point
			int value = -100000;

			for (int i1 = 0; i1 < size; i1++) {
				for (int j1 = 0; j1 < size; j1++) {
					if (table.t[i1][j1] == '.') {
						table.insert(i1, j1, color);
						int value2 = 100000;

						// second level
						for (int i2 = 0; i2 < size; i2++) {
							for (int j2 = 0; j2 < size; j2++) {
								if (table.t[i2][j2] == '.') {
									table.insert(i2, j2, color);
									int value3 = -100000;

									// third level
									for (int i3 = 0; i3 < size; i3++) {
										for (int j3 = 0; j3 < size; j3++) {
											if (table.t[i3][j3] == '.') {
												table.insert(i3, j3, color);
												int value4 = table.valueOfTable();

												if (value4 > value3)
													value3 = value4;
												table.remove(i3, j3);
											}
										}
									}
									if(value3 == -100000){
										value3 = table.valueOfTable();
									}
									if (value3 < value2)
										value2 = value3;
									
									table.remove(i2, j2);
								}
							}
						}
						if(value2 == 100000){
							value2 = table.valueOfTable();
						}
						if (value2 > value) {
							value = value2;
							i = i1;
							j = j1;
						}
						table.remove(i1, j1);
					}
				}
			}
		}else{//for blue player
			// final value of the root point
			int value = 100000;

			for (int i1 = 0; i1 < size; i1++) {
				for (int j1 = 0; j1 < size; j1++) {
					if (table.t[i1][j1] == '.') {
						table.insert(i1, j1, color);
						int value2 = -100000;

						// second level
						for (int i2 = 0; i2 < size; i2++) {
							for (int j2 = 0; j2 < size; j2++) {
								if (table.t[i2][j2] == '.') {
									table.insert(i2, j2, color);
									int value3 = 100000;

									// third level
									for (int i3 = 0; i3 < size; i3++) {
										for (int j3 = 0; j3 < size; j3++) {
											if (table.t[i3][j3] == '.') {
												table.insert(i3, j3, color);
												int value4 = table.valueOfTable();

												if (value4 < value3)
													value3 = value4;
												table.remove(i3, j3);
											}
										}
									}
									if(value3 == -100000){
										value3 = table.valueOfTable();
									}
									if (value3 > value2)
										value2 = value3;
									
									table.remove(i2, j2);
								}
							}
						}
						if(value2 == 100000){
							value2 = table.valueOfTable();
						}
						if (value2 < value) {
							value = value2;
							i = i1;
							j = j1;
						}
						table.remove(i1, j1);
					}
				}
			}
		}
		
		 if (color == 'r') {
		 table.insert(i, j, 'r');
		 } else {
		 table.insert(i, j, 'b');
		 }

		/**** random ****/

		// int i, j;
		// i = (int) (Math.random() * size);
		// j = (int) (Math.random() * size);
		//
		// while (true) {
		// if (table.t[i][j] == '.') {
		// break;
		// }
		// i = (i + 1) % size;
		// if (i == 0)
		// j = (j + 1) % size;
		// }
		//
		// if (color == 'r') {
		// table.insert(i, j, 'r');
		// } else {
		// table.insert(i, j, 'b');
		// }
	}
}
