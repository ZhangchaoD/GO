# GO
多标签
命令：


java -jar Mul_fat.jar test.txt






188维特征解释

前20维，分别是20种氨基酸（按字母序ACDEFGHIKLMNPQRSTVWY），在序列中的含量。（出现个数/序列长度）

21-41维是疏水性特征
        /**   calc_Hydrophobic();
         * string sP="RKEDQN";亲水
         * string sN="GASTPHY";中性 （H应该去亲水）
         * string sH="CVLIMFW";疏水  （W应该去中性）
         */

21-23维分别是亲水、中性、疏水的氨基酸含量 （出现个数/序列长度）

24-26维分别是转换频率，亲水/中性，亲水/疏水，中性/疏水，（出现转换次数/序列长度-1）

27-31维分别是亲水氨基酸第1个，25%个，50%个，75%个和最后一个在序列中的位置，（第n位/序列长度）
32-36维分别是中性氨基酸第1个，25%个，50%个，75%个和最后一个在序列中的位置，（第n位/序列长度）
37-41维分别是疏水氨基酸第1个，25%个，50%个，75%个和最后一个在序列中的位置，（第n位/序列长度）

下面特征类似

42-62是范德华力
 /**  calc_Vanderwaal()
         * string sP="GASCTPD";
         * string sN="NVEQIL";
         * string sH="MHKFRYW";
         */

63-83极性
        /**  calc_Polarity1()
         * string sP="LIFWCMVY";
         * string sN="PATGS";
         * string sH="HQRKNED";
         */

84-104是极化性质
        /**  calc_Polarizability1()
         * string sP="GASDT";
         * string sN="CPNVEQIL";
         * string sH="KMHFRYW";
         */

105-125是电荷性质
        /** calc_Charge()
         * string sP="KR";
         * string sN="ANCQGHILMFPSTWYV";
         * string sH="DE";
         */

126-146是表面张力
        /**  calc_Surfacetension()
         * string sP="GQDNAHR";
         * string sN="KTSEC";
         * string sH="ILMFPWYV";
         */

147-167是二级结构
        /**  calc_Secondarystructure()
         * string sP="EALMQKRH";
         * string sN="VIYCWFT";
         * string sH="GNPSD";
         */
168-188是溶剂可及性
        /**  calc_Solventaccessibility()
         * string sP="ALFCGIVW";
         * string sN="RKQEND";
         * string sH="MPSTHY";
         */
