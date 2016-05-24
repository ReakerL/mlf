/*
用途：检查输入的Email信箱格式是否正确
输入：strEmail：字符串
返回：如果通过验证返回true,否则返回false
*/
function checkEmail(strEmail)
{
 
    //var emailReg = /^[_a-z0-9]+@([_a-z0-9]+\.)+[a-z0-9]{2,3}$/;
 
    var emailReg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
    if ( emailReg.test(strEmail) ) {
        return true;
 
    }
 
    else {
 
        alert("您输入的Email地址格式不正确！");
 
        return false;
 
    }
 
};
 
 
 
/*
用途：校验ip地址的格式
输入：strIP：ip地址
返回：如果通过验证返回true,否则返回false；
*/
 
function isIP(strIP)
{
    if (isNull(strIP)) {
        return false;
    }
    var re = /^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g; //匹配IP地址的正则表达式
    if (re.test(strIP)) {
        if ( RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256) {
            return true;
        }
    }
    return false;
};
/*
用途：检查输入手机号码是否正确
输入：strMobile：字符串
返回：如果通过验证返回true,否则返回false
*/
function checkMobile( strMobile )
{
 
    var regu = /^[1][3][0-9]{9}$/;
    var re = new RegExp(regu);
    if (re.test(strMobile)) {
        return true;
    }
    else {
        return false;
    }
};
/*
用途：检查输入的电话号码格式是否正确
输入：strPhone：字符串
返回：如果通过验证返回true,否则返回false
*/
function checkPhone( strPhone )
{
    var phoneRegWithArea = /^[0][1-9]{2,3}-[0-9]{5,10}$/;
    var phoneRegNoArea = /^[1-9]{1}[0-9]{5,8}$/;
    var prompt = "您输入的电话号码不正确!"; 
    	if ( strPhone.length > 9 ) {
        if ( phoneRegWithArea.test(strPhone) ) {
            return true;
        }
        else {
            alert( prompt );
            return false;
        }
    }
    else {
        if ( phoneRegNoArea.test( strPhone ) ) {
            return true;
        }
        else {
            alert( prompt );
            return false;
        }
    }
};
/*
用途：检查输入字符串是否为空或者全部都是空格
输入：str
返回：如果全是空返回true,否则返回false
*/
 
function isNull( str )
{
    if ( str == "" ) {
        return true;
    }
    var regu = "^[ ]+$";
    var re = new RegExp(regu);
    return re.test(str);
};
/*
用途：检查输入对象的值是否符合整数格式
输入：str 输入的字符串
返回：如果通过验证返回true,否则返回false
*/
function isInteger( str )
{
    var regu = /^[-]{0,1}[0-9]{1,}$/;
    return regu.test(str);
};
/*
用途：检查输入字符串是否符合正整数格式
输入：s：字符串
返回：如果通过验证返回true,否则返回false
*/
function isNumber( s )
{
    var regu = "^[0-9]+$";
    var re = new RegExp(regu);
    if (s.search(re) != - 1) {
        return true;
    }
    else {
        return false;
    }
};
/*
用途：检查输入字符串是否是带小数的数字格式,可以是负数
输入：str：字符串
返回：如果通过验证返回true,否则返回false
*/
function isDecimal( str )
{
    if (isInteger(str)) {
        return true;
    }
    var re = /^[-]{0,1}(\d+)[\.]+(\d+)$/;
    if (re.test(str)) {
        if (RegExp.$1 == 0 && RegExp.$2 == 0) {
            return false;
        }
        return true;
    }
    else {
        return false;
    }
};
/*
用途：检查输入对象的值是否符合端口号格式
输入：str 输入的字符串
返回：如果通过验证返回true,否则返回false
*/
 
function isPort( str )
 
{
 
    return (isNumber(str) && str < 65536);
};
/*
用途：检查输入字符串是否符合金额格式,格式定义为带小数的正数，小数点后最多三位
输入：s：字符串
返回：如果通过验证返回true,否则返回false
*/
function isMoney( s )
{
    var regu = "^[0-9]+[\.][0-9]{0,3}$";
    var re = new RegExp(regu);
    if (re.test(s)) {
        return true;
    }
    else {
        return false;
    }
};
/*
用途：检查输入字符串是否只由英文字母和数字和下划线组成
输入：s：字符串
返回：如果通过验证返回true,否则返回false
*/
function isNumberOr_Letter( s )
{
    //判断是否是数字或字母
    var regu = "^[0-9a-zA-Z\_]+$";
    var re = new RegExp(regu);
    if (re.test(s)) {
        return true;
    }
    else {
        return false;
    }
};
/*
0388
 
0389
用途：检查输入字符串是否只由英文字母和数字组成
0390
 
0391
输入：s：字符串
0392
 
0393
返回：如果通过验证返回true,否则返回false
0394
 
0395
*/
0396
 
0397
function isNumberOrLetter( s )
0398
 
0399
{
0400
 
0401
    //判断是否是数字或字母
0402
 
0403
    var regu = "^[0-9a-zA-Z]+$";
0404
 
0405
    var re = new RegExp(regu);
0406
 
0407
    if (re.test(s)) {
0408
 
0409
        return true;
0410
 
0411
    }
0412
 
0413
    else {
0414
 
0415
        return false;
0416
 
0417
    }
0418
 
0419
};
0420
 
0421
 
0422
 
0423
/*
0424
 
0425
用途：检查输入字符串是否只由汉字、字母、数字组成
0426
 
0427
输入：s：字符串
0428
 
0429
返回：如果通过验证返回true,否则返回false
0430
 
0431
*/
0432
 
0433
function isChinaOrNumbOrLett( s )
0434
 
0435
{
0436
 
0437
    //判断是否是汉字、字母、数字组成
0438
 
0439
    var regu = "^[0-9a-zA-Z\u4e00-\u9fa5]+$";
0440
 
0441
    var re = new RegExp(regu);
0442
 
0443
    if (re.test(s)) {
0444
 
0445
        return true;
0446
 
0447
    }
0448
 
0449
    else {
0450
 
0451
        return false;
0452
 
0453
    }
0454
 
0455
};
0456
 
0457
 
0458
 
0459
/*
0460
 
0461
用途：判断是否是日期
0462
 
0463
输入：date：日期；fmt：日期格式
0464
 
0465
返回：如果通过验证返回true,否则返回false
0466
 
0467
*/
0468
 
0469
function isDate( date, fmt )
0470
 
0471
{
0472
 
0473
    if (fmt == null) {
0474
 
0475
        fmt = "yyyyMMdd";
0476
 
0477
    }
0478
 
0479
    var yIndex = fmt.indexOf("yyyy");
0480
 
0481
    if (yIndex ==- 1) {
0482
 
0483
        return false;
0484
 
0485
    }
0486
 
0487
    var year = date.substring(yIndex, yIndex + 4);
0488
 
0489
    var mIndex = fmt.indexOf("MM");
0490
 
0491
    if (mIndex ==- 1) {
0492
 
0493
        return false;
0494
 
0495
    }
0496
 
0497
    var month = date.substring(mIndex, mIndex + 2);
0498
 
0499
    var dIndex = fmt.indexOf("dd");
0500
 
0501
    if (dIndex ==- 1) {
0502
 
0503
        return false;
0504
 
0505
    }
0506
 
0507
    var day = date.substring(dIndex, dIndex + 2);
0508
 
0509
    if (!isNumber(year) || year > "2100" || year < "1900") {
0510
 
0511
        return false;
0512
 
0513
    }
0514
 
0515
    if (!isNumber(month) || month > "12" || month < "01") {
0516
 
0517
        return false;
0518
 
0519
    }
0520
 
0521
    if (day > getMaxDay(year, month) || day < "01") {
0522
 
0523
        return false;
0524
 
0525
    }
0526
 
0527
    return true;
0528
 
0529
};
0530
 
0531
function getMaxDay(year, month)
0532
 
0533
{
0534
 
0535
    if (month == 4 || month == 6 || month == 9 || month == 11) {
0536
 
0537
        return "30";
0538
 
0539
    }
0540
 
0541
    if (month == 2) {
0542
 
0543
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
0544
 
0545
            return "29";
0546
 
0547
        }
0548
 
0549
        else {
0550
 
0551
            return "28";
0552
 
0553
        }
0554
 
0555
        return "31";;
0556
 
0557
    }
0558
 
0559
};
0560
 
0561
 
0562
 
0563
/*
0564
 
0565
用途：字符1是否以字符串2结束
0566
 
0567
输入：str1：字符串；str2：被包含的字符串
0568
 
0569
返回：如果通过验证返回true,否则返回false
0570
 
0571
*/
0572
 
0573
function isLastMatch(str1, str2)
0574
 
0575
{
0576
 
0577
    var index = str1.lastIndexOf(str2);
0578
 
0579
    if (str1.length == index + str2.length) {
0580
 
0581
        return true;
0582
 
0583
    }
0584
 
0585
    return false;
0586
 
0587
};
0588
 
0589
 
0590
 
0591
/*
0592
 
0593
用途：字符1是否以字符串2开始
0594
 
0595
输入：str1：字符串；str2：被包含的字符串
0596
 
0597
返回：如果通过验证返回true,否则返回false
0598
 
0599
*/
0600
 
0601
function isFirstMatch(str1, str2)
0602
 
0603
{
0604
 
0605
    var index = str1.indexOf(str2);
0606
 
0607
    if (index == 0) {
0608
 
0609
        return true;
0610
 
0611
    }
0612
 
0613
    return false;
0614
 
0615
};
0616
 
0617
 
0618
 
0619
/*
0620
 
0621
用途：字符1是包含字符串2
0622
 
0623
输入：str1：字符串；str2：被包含的字符串
0624
 
0625
返回：如果通过验证返回true,否则返回false
0626
 
0627
*/
0628
 
0629
function isMatch(str1, str2)
0630
 
0631
{
0632
 
0633
    var index = str1.indexOf(str2);
0634
 
0635
    if (index ==- 1) {
0636
 
0637
        return false;
0638
 
0639
    }
0640
 
0641
    return true;
0642
 
0643
};
0644
 
0645
 
0646
 
0647
/*
0648
 
0649
用途：检查输入的起止日期是否正确，规则为两个日期的格式正确，且结束如期>=起始日期
0650
 
0651
输入：startDate：起始日期，字符串; endDate：结束如期，字符串
0652
 
0653
返回：如果通过验证返回true,否则返回false
0654
 
0655
*/
0656
 
0657
function checkTwoDate( startDate, endDate )
0658
 
0659
{
0660
 
0661
    if ( !isDate(startDate) ) {
0662
 
0663
        alert("起始日期不正确!");
0664
 
0665
        return false;
0666
 
0667
    }
0668
 
0669
    else if ( !isDate(endDate) ) {
0670
 
0671
        alert("终止日期不正确!");
0672
 
0673
        return false;
0674
 
0675
    }
0676
 
0677
    else if ( startDate > endDate ) {
0678
 
0679
        alert("起始日期不能大于终止日期!");
0680
 
0681
        return false;
0682
 
0683
    }
0684
 
0685
    return true;
0686
 
0687
};
0688
 
0689
 
0690
 
0691
/*
0692
 
0693
用途：检查复选框被选中的数目
0694
 
0695
输入：checkboxID：字符串
0696
 
0697
返回：返回该复选框中被选中的数目
0698
 
0699
*/
0700
 
0701
function checkSelect( checkboxID )
0702
 
0703
{
0704
 
0705
    var check = 0;
0706
 
0707
    var i = 0;
0708
 
0709
    if ( document.all(checkboxID).length > 0 )
0710
 
0711
    {
0712
 
0713
        for ( i = 0; i < document.all(checkboxID).length; i++ ) {
0714
 
0715
            if ( document.all(checkboxID).item( i ).checked ) {
0716
 
0717
                check += 1;
0718
 
0719
            }
0720
 
0721
        }
0722
 
0723
    }
0724
 
0725
    else {
0726
 
0727
        if ( document.all(checkboxID).checked ) {
0728
 
0729
            check = 1;
0730
 
0731
        }
0732
 
0733
    }
0734
 
0735
    return check;
0736
 
0737
}
0738
 
0739
function getTotalBytes(varField)
0740
 
0741
{
0742
 
0743
    if (varField == null) {
0744
 
0745
        return - 1;
0746
 
0747
    }
0748
 
0749
    var totalCount = 0;
0750
 
0751
    for (i = 0; i < varField.value.length; i++) {
0752
 
0753
        if (varField.value.charCodeAt(i) > 127) {
0754
 
0755
            totalCount += 2;
0756
 
0757
        }
0758
 
0759
        else {
0760
 
0761
            totalCount++ ;
0762
 
0763
        }
0764
 
0765
    }
0766
 
0767
    return totalCount;
0768
 
0769
}
0770
 
0771
function getFirstSelectedValue( checkboxID )
0772
 
0773
{
0774
 
0775
    var value = null;
0776
 
0777
    var i = 0;
0778
 
0779
    if ( document.all(checkboxID).length > 0 )
0780
 
0781
    {
0782
 
0783
        for ( i = 0; i < document.all(checkboxID).length; i++ )
0784
 
0785
        {
0786
 
0787
            if ( document.all(checkboxID).item( i ).checked ) {
0788
 
0789
                value = document.all(checkboxID).item(i).value;
0790
 
0791
                break;
0792
 
0793
            }
0794
 
0795
        }
0796
 
0797
    }
0798
 
0799
    else {
0800
 
0801
        if ( document.all(checkboxID).checked ) {
0802
 
0803
            value = document.all(checkboxID).value;
0804
 
0805
        }
0806
 
0807
    }
0808
 
0809
    return value;
0810
 
0811
}
0812
 
0813
function getFirstSelectedIndex( checkboxID )
0814
 
0815
{
0816
 
0817
    var value = - 2;
0818
 
0819
    var i = 0;
0820
 
0821
    if ( document.all(checkboxID).length > 0 )
0822
 
0823
    {
0824
 
0825
        for ( i = 0; i < document.all(checkboxID).length; i++ ) {
0826
 
0827
            if ( document.all(checkboxID).item( i ).checked ) {
0828
 
0829
                value = i;
0830
 
0831
                break;
0832
 
0833
            }
0834
 
0835
        }
0836
 
0837
    }
0838
 
0839
    else {
0840
 
0841
        if ( document.all(checkboxID).checked ) {
0842
 
0843
            value = - 1;
0844
 
0845
        }
0846
 
0847
    }
0848
 
0849
    return value;
0850
 
0851
}
0852
 
0853
function selectAll( checkboxID, status )
0854
 
0855
{
0856
 
0857
    if ( document.all(checkboxID) == null) {
0858
 
0859
        return;
0860
 
0861
    }
0862
 
0863
    if ( document.all(checkboxID).length > 0 )
0864
 
0865
    {
0866
 
0867
        for ( i = 0; i < document.all(checkboxID).length; i++ ) {
0868
 
0869
            document.all(checkboxID).item( i ).checked = status;
0870
 
0871
        }
0872
 
0873
    }
0874
 
0875
    else {
0876
 
0877
        document.all(checkboxID).checked = status;
0878
 
0879
    }
0880
 
0881
}
0882
 
0883
function selectInverse( checkboxID )
0884
 
0885
{
0886
 
0887
    if ( document.all(checkboxID) == null) {
0888
 
0889
        return;
0890
 
0891
    }
0892
 
0893
    if ( document.all(checkboxID).length > 0 )
0894
 
0895
    {
0896
 
0897
        for ( i = 0; i < document.all(checkboxID).length; i++ )
0898
 
0899
        {
0900
 
0901
            document.all(checkboxID).item( i ).checked = !document.all(checkboxID).item( i ).checked;
0902
 
0903
        }
0904
 
0905
    }
0906
 
0907
    else {
0908
 
0909
        document.all(checkboxID).checked = !document.all(checkboxID).checked;
0910
 
0911
    }
0912
 
0913
}
0914
 
0915
function checkDate( value )
0916
 
0917
{
0918
 
0919
    if (value == '') {
0920
 
0921
        return true;
0922
 
0923
    }
0924
 
0925
    if (value.length != 8 || !isNumber(value)) {
0926
 
0927
        return false;
0928
 
0929
    }
0930
 
0931
    var year = value.substring(0, 4);
0932
 
0933
    if (year > "2100" || year < "1900") {
0934
 
0935
        return false;
0936
 
0937
    }
0938
 
0939
    var month = value.substring(4, 6);
0940
 
0941
    if (month > "12" || month < "01") {
0942
 
0943
        return false;
0944
 
0945
    }
0946
 
0947
    var day = value.substring(6, 8);
0948
 
0949
    if (day > getMaxDay(year, month) || day < "01") {
0950
 
0951
        return false;
0952
 
0953
    }
0954
 
0955
    return true;
0956
 
0957
};
0958
 
0959
 
0960
 
0961
/*
0962
 
0963
用途：检查输入的起止日期是否正确，规则为两个日期的格式正确或都为空且结束日期>=起始日期
0964
 
0965
输入：startDate：起始日期，字符串; endDate： 结束日期，字符串
0966
 
0967
返回：如果通过验证返回true,否则返回false
0968
 
0969
*/
0970
 
0971
function checkPeriod( startDate, endDate )
0972
 
0973
{
0974
 
0975
    if ( !checkDate(startDate) ) {
0976
 
0977
        alert("起始日期不正确!");
0978
 
0979
        return false;
0980
 
0981
    }
0982
 
0983
    else if ( !checkDate(endDate) ) {
0984
 
0985
        alert("终止日期不正确!");
0986
 
0987
        return false;
0988
 
0989
    }
0990
 
0991
    else if ( startDate > endDate ) {
0992
 
0993
        alert("起始日期不能大于终止日期!");
0994
 
0995
        return false;
0996
 
0997
    }
0998
 
0999
    return true;
1000
 
1001
};
1002
 
1003
 
1004
 
1005
/*
1006
 
1007
用途：检查证券代码是否正确
1008
 
1009
输入：secCode:证券代码
1010
 
1011
返回：如果通过验证返回true,否则返回false
1012
 
1013
*/
1014
 
1015
function checkSecCode( secCode )
1016
 
1017
{
1018
 
1019
    if ( secCode.length != 6 ) {
1020
 
1021
        alert("证券代码长度应该为6位");
1022
 
1023
        return false;
1024
 
1025
    }
1026
 
1027
    if (!isNumber( secCode ) ) {
1028
 
1029
        alert("证券代码只能包含数字");
1030
 
1031
        return false;
1032
 
1033
    }
1034
 
1035
    return true;
1036
 
1037
};
1038
 
1039
 
1040
 
1041
/*
1042
 
1043
function:cTrim(sInputString,iType)
1044
 
1045
description:字符串去空格的函数
1046
 
1047
parameters:iType：1=去掉字符串左边的空格;2=去掉字符串左边的空格;0=去掉字符串左边和右边的空格
1048
 
1049
return value:去掉空格的字符串
1050
 
1051
*/
1052
 
1053
function cTrim(sInputString, iType)
1054
 
1055
{
1056
 
1057
    var sTmpStr = ' ';
1058
 
1059
    var i = - 1;
1060
 
1061
    if (iType == 0 || iType == 1)
1062
 
1063
    {
1064
 
1065
        while (sTmpStr == ' ') {
1066
 
1067
            ++i;
1068
 
1069
            sTmpStr = sInputString.substr(i, 1);
1070
 
1071
        }
1072
 
1073
        sInputString = sInputString.substring(i);
1074
 
1075
    }
1076
 
1077
    if (iType == 0 || iType == 2)
1078
 
1079
    {
1080
 
1081
        sTmpStr = ' ';
1082
 
1083
        i = sInputString.length;
1084
 
1085
        while (sTmpStr == ' ') {
1086
 
1087
            --i;
1088
 
1089
            sTmpStr = sInputString.substr(i, 1);
1090
 
1091
        }
1092
 
1093
        sInputString = sInputString.substring(0, i + 1);
1094
 
1095
    }
1096
 
1097
    return sInputString;
1098
 
1099
};
