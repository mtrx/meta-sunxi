DEPENDS = "sunxi-tools-native"

SRC_URI = "git://github.com/linux-sunxi/sunxi-boards.git;protocol=git;branch=master \
          "
SRCREV = "${AUTOREV}"
PR = "r3"

PACKAGE_ARCH = "${MACHINE_ARCH}"

LIC_FILES_CHKSUM = "file://README;md5=55bf0be899507b31d33a4ba25f652513"
LICENSE = "GPLv2"

S = "${WORKDIR}/git"

do_compile() {
    echo "Using board description file ${MACHINE}.fex"
    fex2bin ${S}/sys_config/a10/${MACHINE}.fex ${S}/script.bin
}

do_install() {
    install -d ${D}/${datadir}/sunxi/sunxi-boards
    cp -a sys_config ${D}/${datadir}/sunxi/sunxi-boards/
    install -d ${D}/boot
    cp -av ${S}/script.bin ${D}/boot/
}

do_deploy_prepend () {
    echo "Installing script.bin to ${DEPLOYDIR}"
    install -d ${DEPLOYDIR}
    install ${S}/script.bin ${DEPLOYDIR}/
}

COMPATIBLE_MACHINE = "(cubieboard|cubieboard_512|a10_mid_1gb|h6|gooseberry_a721|hackberry|hyundai_a7hd|mele_a1000|mele_a1000g|mini-x-1gb|mini-x|mk802|mk802ii|zatab)"

FILES_${PN} = "${datadir}/sunxi/* /boot"

