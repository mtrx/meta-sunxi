DESCRIPTION = "Task for extra drivers for Allwinner SoCs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit packagegroup

RDEPENDS_${PN} = "\
	cpufrequtils \
	"

RRECOMMENDS_${PN} = "\
	\
	kernel-module-mali \
	kernel-module-mali-drm \
	\
	kernel-module-sun4i-csi0 \
	kernel-module-sun4i-csi1 \
	kernel-module-sun4i-i2s \
	kernel-module-sun4i-i2sdma \
	\
	kernel-module-sun4i-ir \
	kernel-module-sun4i-keyboard \
	kernel-module-sun4i-keypad \
	\
	kernel-module-sun4i-sndi2s \
	kernel-module-sun4i-sndspdif \
	kernel-module-sun4i-spdif \
	kernel-module-sun4i-spdma \
	\
	kernel-module-sun4i-ts \
	\
	kernel-module-sunxi-dbgreg \
	"
