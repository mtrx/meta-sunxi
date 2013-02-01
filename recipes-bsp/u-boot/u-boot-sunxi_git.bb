require recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://github.com/linux-sunxi/u-boot-sunxi.git;protocol=git;branch=sunxi \
          "
SRCREV = "${AUTOREV}"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"
LICENSE = "GPLv2"

S = "${WORKDIR}/git"

do_install_prepend() {
    cp -av ${S}/spl/sunxi-spl.bin ${S}
}

COMPATIBLE_MACHINE = "(cubieboard|cubieboard_512)"

