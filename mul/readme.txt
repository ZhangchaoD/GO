# GO
多标签
命令：

首先下载mul.rar，把要预测的序列文件拷贝到mul文件夹下，则使用命令行进入到mul文件夹下输入如下命令：
java -jar MultiLabel.jar 输入文件名字 输出文件名字，会得到自己命名的输出文件即为预测结果文件。

此预测使用43个类，每个类均为GO数据库中序列数大于一千条并且是经常出现的类。
43个类整理如下：

Class1	GO:0000981	DNA-binding transcription factor activity, RNA polymerase II-specific
Class2	GO:0001135	RNA polymerase II transcription regulator recruiting activity
Class3	GO:0003700	DNA-binding transcription factor activity
Class4	GO:0003723	RNA binding
Class5	GO:0003735	structural constituent of ribosome
Class6	GO:0004519	endonuclease activity
Class7	GO:0004674	protein serine/threonine kinase activity
Class8	GO:0004675	transmembrane receptor protein serine/threonine kinase activity
Class9	GO:0004842	ubiquitin-protein transferase activity
Class10	GO:0005622	intracellular
Class11	GO:0005634	nucleus
Class12	GO:0005730	nucleolus
Class13	GO:0005737	cytoplasm
Class14	GO:0005739	mitochondrion
Class15	GO:0005783	endoplasmic reticulum
Class16	GO:0005794	Golgi apparatus
Class17	GO:0005829	cytosol
Class18	GO:0005886	plasma membrane
Class19	GO:0005887	integral component of plasma membrane
Class20	GO:0006355	regulation of transcription, DNA-templated
Class21	GO:0006357	regulation of transcription by RNA polymerase II
Class22	GO:0006412	translation
Class23	GO:0006468	protein phosphorylation
Class24	GO:0006508	proteolysis
Class25	GO:0006952	defense response
Class26	GO:0007165	signal transduction
Class27	GO:0007166	cell surface receptor signaling pathway
Class28	GO:0009451	 RNA modification 
Class29	GO:0009506	plasmodesma
Class30	GO:0016020	membrane
Class31	GO:0016021	integral component of membrane 
Class32	GO:0016709	oxidoreductase activity, acting on paired donors, with incorporation or reduction of molecular oxygen, NAD(P)H as one donor, and incorporation of one atom of oxygen
Class33	GO:0022625	cytosolic large ribosomal subunit
Class34	GO:0030154	cell differentiation 
Class35	GO:0035556	intracellular signal transduction
Class36	GO:0043161	proteasome-mediated ubiquitin-dependent protein catabolic process
Class37	GO:0043231	intracellular membrane-bounded organelle 
Class38	GO:0043565	sequence-specific DNA binding
Class39	GO:0044212	transcription regulatory region DNA binding
Class40	GO:0046658	anchored component of plasma membrane
Class41	GO:0061630	ubiquitin protein ligase activity
Class42	GO:0080043	quercetin 3-O-glucosyltransferase activity 
Class43	GO:0080044	quercetin 7-O-glucosyltransferase activity

特征提取使用188维特征：

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
