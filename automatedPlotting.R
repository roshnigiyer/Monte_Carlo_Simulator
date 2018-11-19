## NOTE: MUST SAVE .R FILE, .JAVA, .TXT FILES IN Users/Documents/graphPlotting
## NEED to create a file called graphPlotting in this path first 
## and move the .R and .JAVA file in it

par(mfrow=c(2,1))
# bottom, left, top, right
par(mar=c(6.0,4.1,1.9,4.1))
df = read.table("~/graphPlotting/survivingLeechesData.txt", fill=TRUE)
# extract data from survivingLeeches.txt
numDaysX <- as.numeric(unlist(df[[1]]))
survivingLeechesY <- as.numeric(unlist(df[[2]]))
#maxX <- as.numeric(unlist(df[[1,3]]))
# extract data from aggregateClutchNumData.txt
df2 = read.table("~/graphPlotting/aggregateClutchNum.txt", fill=TRUE)
agClutchDays <- as.numeric(unlist(df2[[1]]))
agClutchesNum <- as.numeric(unlist(df2[[2]]))

# extract data from aggregateEmbryoCount.txt
df3 = read.table("~/graphPlotting/aggregateEmbryoCount.txt", fill=TRUE)
embCountDays <- as.numeric(unlist(df3[[1]]))
embNum <- as.numeric(unlist(df3[[2]]))

# extract data from clutch1Data.txt
c1FileSize <- file.info("~/graphPlotting/clutch1Data.txt")$size 
if (c1FileSize > 0) {
  df4 = read.table("~/graphPlotting/clutch1Data.txt", fill=TRUE)
  clutch1Days <- as.numeric(unlist(df4[[1]]))
  clutch1size <- as.numeric(unlist(df4[[2]]))
}

# extract data from clutch2Data.txt
c2FileSize <- file.info("~/graphPlotting/clutch2Data.txt")$size 
if (c2FileSize > 0) {
  df5 = read.table("~/graphPlotting/clutch2Data.txt", fill=TRUE)
  clutch2Days <- as.numeric(unlist(df5[[1]]))
  clutch2size <- as.numeric(unlist(df5[[2]]))
}

# extract data from clutch3Data.txt
c3FileSize <- file.info("~/graphPlotting/clutch3Data.txt")$size 
if (c3FileSize > 0) {
  df6 = read.table("~/graphPlotting/clutch3Data.txt", fill=TRUE)
  clutch3Days <- as.numeric(unlist(df6[[1]]))
  clutch3size <- as.numeric(unlist(df6[[2]]))
}

# extract data from clutch4Data.txt
c4FileSize <- file.info("~/graphPlotting/clutch4Data.txt")$size 
if (c4FileSize > 0) {
  df7 = read.table("~/graphPlotting/clutch4Data.txt", fill=TRUE)
  clutch4Days <- as.numeric(unlist(df7[[1]]))
  clutch4size <- as.numeric(unlist(df7[[2]]))
}

# extract data from clutch5Data.txt
c5FileSize <- file.info("~/graphPlotting/clutch5Data.txt")$size 
if (c5FileSize > 0) {
  df8 = read.table("~/graphPlotting/clutch5Data.txt", fill=TRUE)
  clutch5Days <- as.numeric(unlist(df8[[1]]))
  clutch5size <- as.numeric(unlist(df8[[2]]))
}

# extract data from clutch6Data.txt
c6FileSize <- file.info("~/graphPlotting/clutch6Data.txt")$size 
if (c6FileSize > 0) {
  df9 = read.table("~/graphPlotting/clutch6Data.txt", fill=TRUE)
  clutch6Days <- as.numeric(unlist(df9[[1]]))
  clutch6size <- as.numeric(unlist(df9[[2]]))
}

# extract data from clutch7Data.txt
c7FileSize <- file.info("~/graphPlotting/clutch7Data.txt")$size 
if (c7FileSize > 0) {
  df10 = read.table("~/graphPlotting/clutch7Data.txt", fill=TRUE)
  clutch7Days <- as.numeric(unlist(df10[[1]]))
  clutch7size <- as.numeric(unlist(df10[[2]]))
}

# extract data from clutch8Data.txt
c8FileSize <- file.info("~/graphPlotting/clutch8Data.txt")$size 
if (c8FileSize > 0) {
  df11 = read.table("~/graphPlotting/clutch8Data.txt", fill=TRUE)
  clutch8Days <- as.numeric(unlist(df11[[1]]))
  clutch8size <- as.numeric(unlist(df11[[2]]))
}

# get the max number of clutches generated
# used for scaling the y-axis "clutch size" for graph 2
largestClutch <- 0
if (max(clutch1size) > largestClutch) {
  largestClutch = max(clutch1size)
}
if (max(clutch2size) > largestClutch) {
  largestClutch = max(clutch2size)
}
if (max(clutch3size) > largestClutch) {
  largestClutch = max(clutch3size)
}
if (max(clutch3size) > largestClutch) {
  largestClutch = max(clutch3size)
}
if (max(clutch4size) > largestClutch) {
  largestClutch = max(clutch4size)
}
if (max(clutch5size) > largestClutch) {
  largestClutch = max(clutch5size)
}
if (max(clutch6size) > largestClutch) {
  largestClutch = max(clutch6size)
}
if (max(clutch7size) > largestClutch) {
  largestClutch = max(clutch7size)
}
if (max(clutch8size) > largestClutch) {
  largestClutch = max(clutch8size)
}

#############################
### GRAPH 1 STARTS HERE #####
#############################

# plot(numDaysX, survivingLeechesY, type="s", 
#      main=expression('H. '*italic(robusta)*' selfing on snails'),
#      col="blue", lwd=3.5, 
#      xlab='Number of Days', ylab='Surviving Leeches', 
#      cex.main=1.1, cex.axis=0.7, cex.lab=0.9,
#      xlim=c(0, max(numDaysX)))

plot(numDaysX, survivingLeechesY, type="s", 
     main=expression('H. '*italic(robusta)*' selfing on snails'),
     col="blue", lwd=3.5, 
     xlab='Number of Days', ylab='Surviving Leeches', 
     cex.main=1.1, cex.axis=0.7, cex.lab=0.9,
     xlim=c(0,480),
     xaxp=c(0, 480, 16),
     ylim=c(0,18),
     yaxp=c(0,18,9))

abline(h=c(0,2,4,6,8,10,12,14,16,18), v=c(0,30,60,90,120,150,180,210,240,270,300,330,360,390,420,450,480), col=c("gray"), lty=9)

par(new=TRUE)
with(df, plot(agClutchDays, agClutchesNum, type="s", lwd=3.5, axes=F, xlab=NA, 
              ylab=NA, cex=1.0, col="darkorange3",
              xlim=c(0,480),
              ylim=c(0,180)))


axis(side = 4, cex.axis=0.7, yaxp=c(0,180,6))
mtext(side = 4, line = 3, 'Aggregate Clutch Number', cex=0.95)
legend("topleft",
       legend=c("Surviving Leeches", "Aggregate Clutch Number"),
       lty=c(1,1), pch=c(NA, NA), col=c("blue", "darkorange3"),
       xpd=TRUE, inset=c(-0.12, 1.12), cex=0.7,
       bty="n")

############################
#### GRAPH 2 STARTS HERE ###
############################

# bottom, left, top, right
par(mar=c(6.45,4.0,1.55,4.2))

plot(embCountDays, embNum, type="s", 
     main=expression('H. '*italic(robusta)*' selfing on snails'),
     col="red", lwd=3.5,
     xlab='Number of Days', ylab='Aggregate Embryo Count',
     cex.main=1.1, cex.axis=0.7, cex.lab=0.9,
     xlim=c(0,480),
     xaxp=c(0, 480, 16),
     ylim=c(0,6000),
     yaxp=c(0,6000,6))

abline(h=c(0,1000,2000,3000,4000,5000,6000), 
       v=c(0,30,60,90,120,150,180,210,240,270,300,330,360,390,420,450,480), col=c("gray"), lty=9)

if (c1FileSize > 0) {
  par(new=TRUE)
  with(df3, plot(clutch1Days, clutch1size, pch=21,
                 lwd=1, axes=F, xlab=NA, ylab=NA,
                 cex=1.0,
                 # col is the outline
                 col="blue", bg="cyan",
                 xlim=c(0, 480),
                 ylim=c(0, 120)))

}

if (c2FileSize > 0) {
  par(new=TRUE)
  with(df3, plot(clutch2Days, clutch2size, pch=21, 
                 lwd=1, axes=F, xlab=NA, ylab=NA, 
                 cex=1.0, 
                 col="gray", bg="orange",
                 xlim=c(0, 480),
                 ylim=c(0, 120)))
}

if (c3FileSize > 0) {
  par(new=TRUE)
  with(df3, plot(clutch3Days, clutch3size, pch=21, 
                 lwd=1, axes=F, xlab=NA, ylab=NA, 
                 cex=1.0, 
                 col="red", bg="white",
                 xlim=c(0, 480),
                 ylim=c(0, 120)))
}

if (c4FileSize > 0) {
  par(new=TRUE)
  with(df3, plot(clutch4Days, clutch4size, pch=21, 
                 lwd=1, axes=F, xlab=NA, ylab=NA, 
                 cex=1.0, 
                 col="gray", bg="yellow",
                 xlim=c(0, 480),
                 ylim=c(0, 120)))
}

if (c5FileSize > 0) {
  par(new=TRUE)
  with(df3, plot(clutch5Days, clutch5size, pch=21, 
                 lwd=1, axes=F, xlab=NA, ylab=NA, 
                 cex=1.0, 
                 col="gray", bg="green",
                 xlim=c(0, 480),
                 ylim=c(0, 120)))
}

if (c6FileSize > 0) {
  par(new=TRUE)
  with(df3, plot(clutch6Days, clutch6size, pch=21, 
                 lwd=1, axes=F, xlab=NA, ylab=NA, 
                 cex=1.0, 
                 col="black", bg="deeppink",
                 xlim=c(0, 480),
                 ylim=c(0, 120)))
}

if (c7FileSize > 0) {
  par(new=TRUE)
  with(df3, plot(clutch7Days, clutch7size, pch=21, 
                 lwd=1, axes=F, xlab=NA, ylab=NA, 
                 cex=1.0, 
                 col="black", bg="white",
                 xlim=c(0, 480),
                 ylim=c(0, 120)))
}

if (c8FileSize > 0) {
  par(new=TRUE)
  with(df3, plot(clutch8Days, clutch8size, pch=21, 
                 lwd=1, axes=F, xlab=NA, ylab=NA, 
                 cex=1.0, 
                 col="yellow", bg="black",
                 xlim=c(0, 480),
                 ylim=c(0, 120)))
}

axis(side = 4, cex.axis=0.7, yaxp=c(0,120,4))
mtext(side = 4, line = 3, 'Clutch Size', cex=0.95)

#legend 1 has aggregate embryo count up to clutch2
legend("topleft",
       legend=c("Aggregate Embryo Count", 
                if (c1FileSize > 0) {
                  "Clutch1"
                },
                if (c2FileSize > 0) {
                  "Clutch2"
                }),
       lty=c(1, 
             if (c1FileSize > 0) {
                0
             },
             if (c2FileSize > 0) {
               0
             }), 
       
       pch=c(NA,
             if (c1FileSize > 0) {
               21
             },
             if (c2FileSize > 0) {
               21
             }),
       xpd=TRUE, inset=c(-0.12, 1.12), cex=0.7,
       col=c("red", 
             if (c1FileSize > 0) {
               "blue"
             },
             if (c2FileSize > 0) {
               "gray"
             }), 
       pt.bg=c("white",
               if (c1FileSize > 0) {
                 "cyan"
               },
               if (c2FileSize > 0) {
                 "orange"
               }),
       bty="n")

# includes clutch3 and clutch4
legend("topleft",
       legend=c(
              if (c3FileSize > 0) {
                "Clutch3"
              },
              if (c4FileSize > 0) {
                "Clutch4"
        
              }),
       lty=c( 
              if (c3FileSize > 0) {
                0
              },
              if (c4FileSize > 0) {
                0
              }), 
       pch=c(
              if (c3FileSize > 0) {
                21
              },
              if (c4FileSize > 0) {
                21
              }),
       xpd=TRUE, inset=c(0.070, 1.172), cex=0.7,
       col=c(
              if (c3FileSize > 0) {
                "red"
              },
              if (c4FileSize > 0) {
                "gray"
              }), 
       pt.bg=c(
              if (c3FileSize > 0) {
                "white"
              },
              if (c4FileSize > 0) {
                "yellow"
              }),
       bty="n")

#includes clutch5 and clutch6
legend("topleft",
       legend=c(
         if (c5FileSize > 0) {
           "Clutch5"
         },
         if (c6FileSize > 0) {
           "Clutch6"
         }),
       lty=c( 
         if (c5FileSize > 0) {
           0
         },
         if (c6FileSize > 0) {
           0
         }), 
       
       pch=c(
         if (c5FileSize > 0) {
           21
         },
         if (c6FileSize > 0) {
           21
         }),
       xpd=TRUE, inset=c(0.240, 1.172), cex=0.7,
       col=c(
         if (c5FileSize > 0) {
           "gray"
         },
         if (c6FileSize > 0) {
           "black"
         }), 
       pt.bg=c(
         if (c5FileSize > 0) {
           "green"
         },
         if (c6FileSize > 0) {
           "deeppink"
         }),
       bty="n")

#includes clutch7 and clutch8
legend("topleft",
       legend=c(
         if (c7FileSize > 0) {
           "Clutch7"
         },
         if (c8FileSize > 0) {
           "Clutch8"
         }),
       lty=c( 
         if (c7FileSize > 0) {
           0
         },
         if (c8FileSize > 0) {
           0
         }), 
       pch=c(
         if (c7FileSize > 0) {
           21
         },
         if (c8FileSize > 0) {
           21
         }),
       xpd=TRUE, inset=c(0.40, 1.172), cex=0.7,
       col=c(
         if (c7FileSize > 0) {
           "black"
         },
         if (c8FileSize > 0) {
           "yellow"
         }), 
       pt.bg=c(
         if (c7FileSize > 0) {
           "white"
         },
         if (c8FileSize > 0) {
           "black"
         }),
       bty="n")


