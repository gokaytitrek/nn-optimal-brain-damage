package skynet;

public class SkyNet {
    // Test class
    public static void main(String[] args) {
        double[][] allData = new double[150][];
        allData[0] = new double[] { 5.1, 3.5, 1.4, 0.2, 0, 0, 1 }; // sepal length, sepal width, petal length, petal width -> 
        allData[1] = new double[] { 4.9, 3.0, 1.4, 0.2, 0, 0, 1 }; // Iris setosa = 0 0 1, Iris versicolor = 0 1 0, Iris virginica = 1 0 0
        allData[2] = new double[] { 4.7, 3.2, 1.3, 0.2, 0, 0, 1 };
        allData[3] = new double[] { 4.6, 3.1, 1.5, 0.2, 0, 0, 1 };
        allData[4] = new double[] { 5.0, 3.6, 1.4, 0.2, 0, 0, 1 };
        allData[5] = new double[] { 5.4, 3.9, 1.7, 0.4, 0, 0, 1 };
        allData[6] = new double[] { 4.6, 3.4, 1.4, 0.3, 0, 0, 1 };
        allData[7] = new double[] { 5.0, 3.4, 1.5, 0.2, 0, 0, 1 };
        allData[8] = new double[] { 4.4, 2.9, 1.4, 0.2, 0, 0, 1 };
        allData[9] = new double[] { 4.9, 3.1, 1.5, 0.1, 0, 0, 1 };

        allData[10] = new double[] { 5.4, 3.7, 1.5, 0.2, 0, 0, 1 };
        allData[11] = new double[] { 4.8, 3.4, 1.6, 0.2, 0, 0, 1 };
        allData[12] = new double[] { 4.8, 3.0, 1.4, 0.1, 0, 0, 1 };
        allData[13] = new double[] { 4.3, 3.0, 1.1, 0.1, 0, 0, 1 };
        allData[14] = new double[] { 5.8, 4.0, 1.2, 0.2, 0, 0, 1 };
        allData[15] = new double[] { 5.7, 4.4, 1.5, 0.4, 0, 0, 1 };
        allData[16] = new double[] { 5.4, 3.9, 1.3, 0.4, 0, 0, 1 };
        allData[17] = new double[] { 5.1, 3.5, 1.4, 0.3, 0, 0, 1 };
        allData[18] = new double[] { 5.7, 3.8, 1.7, 0.3, 0, 0, 1 };
        allData[19] = new double[] { 5.1, 3.8, 1.5, 0.3, 0, 0, 1 };

        allData[20] = new double[] { 5.4, 3.4, 1.7, 0.2, 0, 0, 1 };
        allData[21] = new double[] { 5.1, 3.7, 1.5, 0.4, 0, 0, 1 };
        allData[22] = new double[] { 4.6, 3.6, 1.0, 0.2, 0, 0, 1 };
        allData[23] = new double[] { 5.1, 3.3, 1.7, 0.5, 0, 0, 1 };
        allData[24] = new double[] { 4.8, 3.4, 1.9, 0.2, 0, 0, 1 };
        allData[25] = new double[] { 5.0, 3.0, 1.6, 0.2, 0, 0, 1 };
        allData[26] = new double[] { 5.0, 3.4, 1.6, 0.4, 0, 0, 1 };
        allData[27] = new double[] { 5.2, 3.5, 1.5, 0.2, 0, 0, 1 };
        allData[28] = new double[] { 5.2, 3.4, 1.4, 0.2, 0, 0, 1 };
        allData[29] = new double[] { 4.7, 3.2, 1.6, 0.2, 0, 0, 1 };

        allData[30] = new double[] { 4.8, 3.1, 1.6, 0.2, 0, 0, 1 };
        allData[31] = new double[] { 5.4, 3.4, 1.5, 0.4, 0, 0, 1 };
        allData[32] = new double[] { 5.2, 4.1, 1.5, 0.1, 0, 0, 1 };
        allData[33] = new double[] { 5.5, 4.2, 1.4, 0.2, 0, 0, 1 };
        allData[34] = new double[] { 4.9, 3.1, 1.5, 0.1, 0, 0, 1 };
        allData[35] = new double[] { 5.0, 3.2, 1.2, 0.2, 0, 0, 1 };
        allData[36] = new double[] { 5.5, 3.5, 1.3, 0.2, 0, 0, 1 };
        allData[37] = new double[] { 4.9, 3.1, 1.5, 0.1, 0, 0, 1 };
        allData[38] = new double[] { 4.4, 3.0, 1.3, 0.2, 0, 0, 1 };
        allData[39] = new double[] { 5.1, 3.4, 1.5, 0.2, 0, 0, 1 };

        allData[40] = new double[] { 5.0, 3.5, 1.3, 0.3, 0, 0, 1 };
        allData[41] = new double[] { 4.5, 2.3, 1.3, 0.3, 0, 0, 1 };
        allData[42] = new double[] { 4.4, 3.2, 1.3, 0.2, 0, 0, 1 };
        allData[43] = new double[] { 5.0, 3.5, 1.6, 0.6, 0, 0, 1 };
        allData[44] = new double[] { 5.1, 3.8, 1.9, 0.4, 0, 0, 1 };
        allData[45] = new double[] { 4.8, 3.0, 1.4, 0.3, 0, 0, 1 };
        allData[46] = new double[] { 5.1, 3.8, 1.6, 0.2, 0, 0, 1 };
        allData[47] = new double[] { 4.6, 3.2, 1.4, 0.2, 0, 0, 1 };
        allData[48] = new double[] { 5.3, 3.7, 1.5, 0.2, 0, 0, 1 };
        allData[49] = new double[] { 5.0, 3.3, 1.4, 0.2, 0, 0, 1 };

        allData[50] = new double[] { 7.0, 3.2, 4.7, 1.4, 0, 1, 0 };
        allData[51] = new double[] { 6.4, 3.2, 4.5, 1.5, 0, 1, 0 };
        allData[52] = new double[] { 6.9, 3.1, 4.9, 1.5, 0, 1, 0 };
        allData[53] = new double[] { 5.5, 2.3, 4.0, 1.3, 0, 1, 0 };
        allData[54] = new double[] { 6.5, 2.8, 4.6, 1.5, 0, 1, 0 };
        allData[55] = new double[] { 5.7, 2.8, 4.5, 1.3, 0, 1, 0 };
        allData[56] = new double[] { 6.3, 3.3, 4.7, 1.6, 0, 1, 0 };
        allData[57] = new double[] { 4.9, 2.4, 3.3, 1.0, 0, 1, 0 };
        allData[58] = new double[] { 6.6, 2.9, 4.6, 1.3, 0, 1, 0 };
        allData[59] = new double[] { 5.2, 2.7, 3.9, 1.4, 0, 1, 0 };

        allData[60] = new double[] { 5.0, 2.0, 3.5, 1.0, 0, 1, 0 };
        allData[61] = new double[] { 5.9, 3.0, 4.2, 1.5, 0, 1, 0 };
        allData[62] = new double[] { 6.0, 2.2, 4.0, 1.0, 0, 1, 0 };
        allData[63] = new double[] { 6.1, 2.9, 4.7, 1.4, 0, 1, 0 };
        allData[64] = new double[] { 5.6, 2.9, 3.6, 1.3, 0, 1, 0 };
        allData[65] = new double[] { 6.7, 3.1, 4.4, 1.4, 0, 1, 0 };
        allData[66] = new double[] { 5.6, 3.0, 4.5, 1.5, 0, 1, 0 };
        allData[67] = new double[] { 5.8, 2.7, 4.1, 1.0, 0, 1, 0 };
        allData[68] = new double[] { 6.2, 2.2, 4.5, 1.5, 0, 1, 0 };
        allData[69] = new double[] { 5.6, 2.5, 3.9, 1.1, 0, 1, 0 };

        allData[70] = new double[] { 5.9, 3.2, 4.8, 1.8, 0, 1, 0 };
        allData[71] = new double[] { 6.1, 2.8, 4.0, 1.3, 0, 1, 0 };
        allData[72] = new double[] { 6.3, 2.5, 4.9, 1.5, 0, 1, 0 };
        allData[73] = new double[] { 6.1, 2.8, 4.7, 1.2, 0, 1, 0 };
        allData[74] = new double[] { 6.4, 2.9, 4.3, 1.3, 0, 1, 0 };
        allData[75] = new double[] { 6.6, 3.0, 4.4, 1.4, 0, 1, 0 };
        allData[76] = new double[] { 6.8, 2.8, 4.8, 1.4, 0, 1, 0 };
        allData[77] = new double[] { 6.7, 3.0, 5.0, 1.7, 0, 1, 0 };
        allData[78] = new double[] { 6.0, 2.9, 4.5, 1.5, 0, 1, 0 };
        allData[79] = new double[] { 5.7, 2.6, 3.5, 1.0, 0, 1, 0 };

        allData[80] = new double[] { 5.5, 2.4, 3.8, 1.1, 0, 1, 0 };
        allData[81] = new double[] { 5.5, 2.4, 3.7, 1.0, 0, 1, 0 };
        allData[82] = new double[] { 5.8, 2.7, 3.9, 1.2, 0, 1, 0 };
        allData[83] = new double[] { 6.0, 2.7, 5.1, 1.6, 0, 1, 0 };
        allData[84] = new double[] { 5.4, 3.0, 4.5, 1.5, 0, 1, 0 };
        allData[85] = new double[] { 6.0, 3.4, 4.5, 1.6, 0, 1, 0 };
        allData[86] = new double[] { 6.7, 3.1, 4.7, 1.5, 0, 1, 0 };
        allData[87] = new double[] { 6.3, 2.3, 4.4, 1.3, 0, 1, 0 };
        allData[88] = new double[] { 5.6, 3.0, 4.1, 1.3, 0, 1, 0 };
        allData[89] = new double[] { 5.5, 2.5, 4.0, 1.3, 0, 1, 0 };

        allData[90] = new double[] { 5.5, 2.6, 4.4, 1.2, 0, 1, 0 };
        allData[91] = new double[] { 6.1, 3.0, 4.6, 1.4, 0, 1, 0 };
        allData[92] = new double[] { 5.8, 2.6, 4.0, 1.2, 0, 1, 0 };
        allData[93] = new double[] { 5.0, 2.3, 3.3, 1.0, 0, 1, 0 };
        allData[94] = new double[] { 5.6, 2.7, 4.2, 1.3, 0, 1, 0 };
        allData[95] = new double[] { 5.7, 3.0, 4.2, 1.2, 0, 1, 0 };
        allData[96] = new double[] { 5.7, 2.9, 4.2, 1.3, 0, 1, 0 };
        allData[97] = new double[] { 6.2, 2.9, 4.3, 1.3, 0, 1, 0 };
        allData[98] = new double[] { 5.1, 2.5, 3.0, 1.1, 0, 1, 0 };
        allData[99] = new double[] { 5.7, 2.8, 4.1, 1.3, 0, 1, 0 };

        allData[100] = new double[] { 6.3, 3.3, 6.0, 2.5, 1, 0, 0 };
        allData[101] = new double[] { 5.8, 2.7, 5.1, 1.9, 1, 0, 0 };
        allData[102] = new double[] { 7.1, 3.0, 5.9, 2.1, 1, 0, 0 };
        allData[103] = new double[] { 6.3, 2.9, 5.6, 1.8, 1, 0, 0 };
        allData[104] = new double[] { 6.5, 3.0, 5.8, 2.2, 1, 0, 0 };
        allData[105] = new double[] { 7.6, 3.0, 6.6, 2.1, 1, 0, 0 };
        allData[106] = new double[] { 4.9, 2.5, 4.5, 1.7, 1, 0, 0 };
        allData[107] = new double[] { 7.3, 2.9, 6.3, 1.8, 1, 0, 0 };
        allData[108] = new double[] { 6.7, 2.5, 5.8, 1.8, 1, 0, 0 };
        allData[109] = new double[] { 7.2, 3.6, 6.1, 2.5, 1, 0, 0 };

        allData[110] = new double[] { 6.5, 3.2, 5.1, 2.0, 1, 0, 0 };
        allData[111] = new double[] { 6.4, 2.7, 5.3, 1.9, 1, 0, 0 };
        allData[112] = new double[] { 6.8, 3.0, 5.5, 2.1, 1, 0, 0 };
        allData[113] = new double[] { 5.7, 2.5, 5.0, 2.0, 1, 0, 0 };
        allData[114] = new double[] { 5.8, 2.8, 5.1, 2.4, 1, 0, 0 };
        allData[115] = new double[] { 6.4, 3.2, 5.3, 2.3, 1, 0, 0 };
        allData[116] = new double[] { 6.5, 3.0, 5.5, 1.8, 1, 0, 0 };
        allData[117] = new double[] { 7.7, 3.8, 6.7, 2.2, 1, 0, 0 };
        allData[118] = new double[] { 7.7, 2.6, 6.9, 2.3, 1, 0, 0 };
        allData[119] = new double[] { 6.0, 2.2, 5.0, 1.5, 1, 0, 0 };

        allData[120] = new double[] { 6.9, 3.2, 5.7, 2.3, 1, 0, 0 };
        allData[121] = new double[] { 5.6, 2.8, 4.9, 2.0, 1, 0, 0 };
        allData[122] = new double[] { 7.7, 2.8, 6.7, 2.0, 1, 0, 0 };
        allData[123] = new double[] { 6.3, 2.7, 4.9, 1.8, 1, 0, 0 };
        allData[124] = new double[] { 6.7, 3.3, 5.7, 2.1, 1, 0, 0 };
        allData[125] = new double[] { 7.2, 3.2, 6.0, 1.8, 1, 0, 0 };
        allData[126] = new double[] { 6.2, 2.8, 4.8, 1.8, 1, 0, 0 };
        allData[127] = new double[] { 6.1, 3.0, 4.9, 1.8, 1, 0, 0 };
        allData[128] = new double[] { 6.4, 2.8, 5.6, 2.1, 1, 0, 0 };
        allData[129] = new double[] { 7.2, 3.0, 5.8, 1.6, 1, 0, 0 };

        allData[130] = new double[] { 7.4, 2.8, 6.1, 1.9, 1, 0, 0 };
        allData[131] = new double[] { 7.9, 3.8, 6.4, 2.0, 1, 0, 0 };
        allData[132] = new double[] { 6.4, 2.8, 5.6, 2.2, 1, 0, 0 };
        allData[133] = new double[] { 6.3, 2.8, 5.1, 1.5, 1, 0, 0 };
        allData[134] = new double[] { 6.1, 2.6, 5.6, 1.4, 1, 0, 0 };
        allData[135] = new double[] { 7.7, 3.0, 6.1, 2.3, 1, 0, 0 };
        allData[136] = new double[] { 6.3, 3.4, 5.6, 2.4, 1, 0, 0 };
        allData[137] = new double[] { 6.4, 3.1, 5.5, 1.8, 1, 0, 0 };
        allData[138] = new double[] { 6.0, 3.0, 4.8, 1.8, 1, 0, 0 };
        allData[139] = new double[] { 6.9, 3.1, 5.4, 2.1, 1, 0, 0 };

        allData[140] = new double[] { 6.7, 3.1, 5.6, 2.4, 1, 0, 0 };
        allData[141] = new double[] { 6.9, 3.1, 5.1, 2.3, 1, 0, 0 };
        allData[142] = new double[] { 5.8, 2.7, 5.1, 1.9, 1, 0, 0 };
        allData[143] = new double[] { 6.8, 3.2, 5.9, 2.3, 1, 0, 0 };
        allData[144] = new double[] { 6.7, 3.3, 5.7, 2.5, 1, 0, 0 };
        allData[145] = new double[] { 6.7, 3.0, 5.2, 2.3, 1, 0, 0 };
        allData[146] = new double[] { 6.3, 2.5, 5.0, 1.9, 1, 0, 0 };
        allData[147] = new double[] { 6.5, 3.0, 5.2, 2.0, 1, 0, 0 };
        allData[148] = new double[] { 6.2, 3.4, 5.4, 2.3, 1, 0, 0 };
        allData[149] = new double[] { 5.9, 3.0, 5.1, 1.8, 1, 0, 0 };
        
        NeuralNetwork nn = new NeuralNetwork(4,0);
        Layer l1 = new Layer(7,0);
        nn.addLayer(l1);
        Layer l2 = new Layer(3,0);
        nn.addLayer(l2);

        nn.backPropagation(allData);
    }
}
