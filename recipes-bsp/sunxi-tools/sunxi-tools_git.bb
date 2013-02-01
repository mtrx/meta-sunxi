
SRC_URI = "git://github.com/linux-sunxi/sunxi-tools.git;protocol=git;branch=master \
           file://getopt.patch;patch=1"

SRCREV = "${AUTOREV}"
PR = "r2"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
LICENSE = "GPLv2"

DEPENDS = "libusb"

BBCLASSEXTEND = "native"

CFLAGS_prepend = " -std=c99 -Iinclude "

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/$sbindir
    TOOLS="fexc bin2fex fex2bin bootinfo fel pio nand-part"
    for T in $TOOLS; do
        [ -e ${S}/$T ] && install -v ${S}/$T ${D}/$sbindir
    done
}

