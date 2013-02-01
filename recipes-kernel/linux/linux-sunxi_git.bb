DESCRIPTION = "Linux kernel for Allwinner A10 boards"
KERNEL_IMAGETYPE = "uImage"

require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "3.0.52"
PR = "${INC_PR}.3"
PV = "${LINUX_VERSION}+git${SRCPV}"

# The main PR is now using MACHINE_KERNEL_PR
MACHINE_KERNEL_PR_append = "a"

SRC_URI = "git://github.com/linux-sunxi/linux-sunxi.git;branch=sunxi-3.0;protocol=git;bareclone=1"
SRCREV = "${AUTOREV}"
KBRANCH = "sunxi-3.0"

SRC_URI += "file://defconfig.cfg"

do_remove_modules() {
    echo "Cleanup modules/ folder..."
    rm -rfv ${S}/modules
}
addtask remove_modules before do_compile after do_patch

do_install_append() {
    rm -rfv ${D}/usr/src/kernel/drivers/media/video/sun4i_csi/test/
    rm -fv  ${D}/usr/src/kernel/arch/arm/mach-sun4i/pm/standby/standby.elf
}

COMPATIBLE_MACHINE = "cubieboard"
